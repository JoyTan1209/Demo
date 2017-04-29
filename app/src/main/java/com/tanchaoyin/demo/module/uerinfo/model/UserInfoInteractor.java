package com.tanchaoyin.demo.module.uerinfo.model;

import com.tanchaoyin.demo.common.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public interface UserInfoInteractor<T> {

    /**
     *
     * Users
     *
     * @param callback
     * @param user
     * @return
     */
    Subscription userInfo(RequestCallback<T> callback, String user);

    /**
     * UserRepos
     *
     * @param callback
     * @param url
     * @return
     */
    Subscription suerRepos(RequestCallback<T> callback, String url);
}
