package com.tanchaoyin.demo.api;

import com.socks.library.KLog;
import com.tanchaoyin.demo.base.NoNetworkException;
import com.tanchaoyin.demo.common.CommonConstant;
import com.tanchaoyin.demo.app.App;
import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.entry.UserRepos;
import com.tanchaoyin.demo.utils.NetUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class RetrofitManager {

    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 76760;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 76760;

    //设缓存有效期为两天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置，头部Cache-Control设为max-age=0时则不会使用缓存而请求服务器
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";

    public Retrofit retrofit;
    public ApiService movieService;

    private ApiService apiService;

    private OkHttpClient okHttpClient;

    private static RetrofitManager retrofitManagerInstance;

    public static RetrofitManager getInstance() {
        // 第一次检查
        if (null == retrofitManagerInstance) {
            synchronized (RetrofitManager.class) {
                // 第二次检查
                if (retrofitManagerInstance == null) {
                    retrofitManagerInstance = new RetrofitManager();
                }
            }
        }
        return retrofitManagerInstance;
    }

    private RetrofitManager() {

        initOkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.SERVER)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        this.apiService = retrofit.create(ApiService.class);
    }

    private void initOkHttpClient() {
        if (okHttpClient == null) {

            synchronized (RetrofitManager.class) {

                if (null == okHttpClient) {
                    KLog.e("初始化mOkHttpClient");
                    // 因为BaseUrl不同所以这里Retrofit不为静态，但是OkHttpClient配置是一样的,静态创建一次即可

                    // 指定缓存路径,缓存大小100Mb
                    Cache cache = new Cache(new File(App.getInstance().getContext().getCacheDir(), CommonConstant.ROOT_DIR_PATH+"/HttpCache"),
                            1024 * 1024 * 100);

                    okHttpClient = new OkHttpClient.Builder()
                            .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                            .connectTimeout(CONNECT_TIME_OUT,TimeUnit.MILLISECONDS)
//                            .cache(cache)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mLoggingInterceptor).retryOnConnectionFailure(true)
                            .build();

                }
            }
        }
    }

    // 云端响应头拦截器，用来配置缓存策略
    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isConnected(App.getInstance().getContext())) {

                KLog.e("no network");
                throw new NoNetworkException();

            } else {

                request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
                Response originalResponse = chain.proceed(request);

//            if (NetUtil.isConnected(App.getContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                KLog.v("--------------------------------------------开始打印Url数据----------------------------------------------------");
                KLog.v(request.url()+cacheControl);
                KLog.v("--------------------------------------------结束打印Url数据----------------------------------------------------");
                return originalResponse.newBuilder().header("Cache-Control", cacheControl)
                        .removeHeader("Pragma").build();
            }

        }
    };

    // 打印返回的json数据拦截器
    private Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) {

            final Request request = chain.request();
            Response response = null;

            try {
                response = chain.proceed(request);

                final ResponseBody responseBody = response.body();
                final long contentLength = responseBody.contentLength();

                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = Charset.forName("UTF-8");
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(charset);
                    } catch (UnsupportedCharsetException e) {
                        KLog.e("");
                        KLog.e("Couldn't decode the response body; charset is likely malformed.");
                        return response;
                    }
                }

                if (contentLength != 0) {
                    KLog.v("--------------------------------------------开始打印返回数据----------------------------------------------------");
                    KLog.json(buffer.clone().readString(charset));
                    KLog.v("--------------------------------------------结束打印返回数据----------------------------------------------------");
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

            return response;
        }
    };

    /**
     * 用户
     *
     * @param user
     * @return
     */
    public Observable<UserInfo> userInfo(String user) {
        return apiService.userInfo(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    /**
     * User Repos
     *
     * @param url
     * @return
     */
    public Observable<List<UserRepos>> userRepos(String url) {
        return apiService.userRepos(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
}
