package com.tanchaoyin.demo.module.uerinfo.model.impl;

import com.socks.library.KLog;
import com.tanchaoyin.demo.api.RetrofitManager;
import com.tanchaoyin.demo.base.NoNetworkException;
import com.tanchaoyin.demo.common.callback.RequestCallback;
import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.entry.UserRepos;
import com.tanchaoyin.demo.module.uerinfo.model.UserInfoInteractor;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class UserInfoInteractorImpl implements UserInfoInteractor {

    @Override
    public Subscription userInfo(final RequestCallback callback, final String user) {
        return RetrofitManager.getInstance()
                .userInfo(user)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (throwable instanceof NoNetworkException) {
                            KLog.e("\"错误时处理： 无网络链接\"");
                            callback.requestError("no_net_work");
                        } else {
                            KLog.e("错误时处理" + throwable + "----" + throwable.getLocalizedMessage());
                            callback.requestError(throwable.getLocalizedMessage());
                        }
                    }
                }).subscribe(new Subscriber<UserInfo>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getLocalizedMessage() + "\n" + e);
                        callback.requestError(e.getLocalizedMessage() + "\n" + e);
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        callback.requestSuccess(userInfo);
                    }
                });
    }

    @Override
    public Subscription suerRepos(final RequestCallback callback, final String url) {
        return RetrofitManager.getInstance()
                .userRepos(url)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (throwable instanceof NoNetworkException) {
                            KLog.e("\"错误时处理： 无网络链接\"");
                            callback.requestError("no_net_work");
                        } else {
                            KLog.e("错误时处理" + throwable + "----" + throwable.getLocalizedMessage());
                            callback.requestError(throwable.getLocalizedMessage());
                        }
                    }
                }).subscribe(new Subscriber<List<UserRepos>>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getLocalizedMessage() + "\n" + e);
                        callback.requestError(e.getLocalizedMessage() + "\n" + e);
                    }

                    @Override
                    public void onNext(List<UserRepos> userRepos) {
                        callback.requestSuccess(userRepos);
                    }
                });

    }
}
