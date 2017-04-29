package com.tanchaoyin.demo.base.impl;

import com.socks.library.KLog;
import com.tanchaoyin.demo.base.BasePresenter;
import com.tanchaoyin.demo.base.BaseView;
import com.tanchaoyin.demo.common.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class BasePresenterImpl<T extends BaseView, V>  implements BasePresenter,RequestCallback<V> {

    protected Subscription subscription;

    protected T view;

    public BasePresenterImpl(T view) {

        this.view = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        view = null;
    }

    @Override
    public void beforeRequest() {
        view.showProgress();
    }

    @Override
    public void requestError(String msg) {
        KLog.e(msg);
        if (null != view) {
            view.toast(msg);
            view.hideProgress();
        }
    }

    @Override
    public void requestComplete() {
        view.hideProgress();
    }

    @Override
    public void requestSuccess(V data) {
        view.hideProgress();
    }

}
