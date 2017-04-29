package com.tanchaoyin.demo.app;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tanchaoyin.demo.BuildConfig;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class App extends Application {

    private static final String TAG = App.class.getName();

    public Context context;

    /**
     * 内存监控
     */
    private RefWatcher mRefWatcher;

    private static App appInstance;

    public static App getInstance() {
        // 第一次检查
        if (null == appInstance) {
            synchronized (App.class) {
                // 第二次检查
                if (appInstance == null) {
                    appInstance = new App();
                }
            }
        }
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appInstance = this;

        context = this;

        // KLog 初始化
        KLog.init(BuildConfig.DEBUG);

        mRefWatcher = LeakCanary.install(this);
    }

    /**
     * 获取ApplicationContext
     *
     * @return
     */
    public Context getContext() {
        return context;
    }
}
