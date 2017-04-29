package com.tanchaoyin.demo.base;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.tanchaoyin.demo.R;
import com.tanchaoyin.demo.app.AppManager;
import com.tanchaoyin.demo.common.CommonConstant;

import butterknife.ButterKnife;
import rx.Observable;

public abstract class BaseAppCompatActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    public final static String IS_START_ANIM = "IS_START_ANIM";
    public final static String IS_CLOSE_ANIM = "IS_CLOSE_ANIM";
    protected boolean isStartAnim = true;
    protected boolean isCloseAnim = true;
    /**
     * 将代理类通用行为抽出来
     */
    protected T presenter;

    /**
     * 结束Activity的可观测对象
     */
    private Observable<Boolean> finishObservable;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        setContentView(getLayoutView());

        ButterKnife.bind(this);

        parseIntent(getIntent());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        initView();

        AppManager.getInstance().addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null) {
            presenter.onDestroy();
        }

        AppManager.getInstance().killSingleActivity(this);
    }

    @Override
    public void toast(String msg) {
        if (CommonConstant.SERVER_CONNECTION_FAILED.equals(msg)) {
            setContentView(R.layout.layout_server_connection_failed);
        } else if (CommonConstant.NETWORK_ERROR.equals(msg)) {
            setContentView(R.layout.layout_network_error);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    /**
     * 增加了默认的返回finish事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @TargetApi(19)
    private void initWindow(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    //call before super.onCreate(savedInstanceState)
    protected void launchWithNoAnim() {
        isStartAnim = false;
    }

    private void parseIntent(Intent intent){
        if (intent != null) {
            isStartAnim = intent.getBooleanExtra(IS_START_ANIM, true);
            isCloseAnim = intent.getBooleanExtra(IS_CLOSE_ANIM, true);
        }
    }

    public int getStatusBarColor(){
        return getColorPrimary();
    }

    public int getColorPrimary(){
        TypedValue typedValue = new  TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    public int getDarkColorPrimary(){
        TypedValue typedValue = new  TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        return typedValue.data;
    }

    public int getCompactColor(@ColorRes int res){
        if (res <= 0)
            throw new IllegalArgumentException("resource id can not be less 0");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getColor(res);
        }
        return getResources().getColor(res);
    }

    protected void initToolbar(){

    }

    protected void initTitleBar() {

    }

    public void reload(boolean anim) {
        Intent intent = getIntent();
        if (!anim) {
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            intent.putExtra(BaseAppCompatActivity.IS_START_ANIM, false);
        }
        finish();
        if (!anim) {
            overridePendingTransition(0, 0);
        }
        startActivity(intent);
    }

    protected abstract void initView();

    protected abstract @LayoutRes
    int getLayoutView();
}
