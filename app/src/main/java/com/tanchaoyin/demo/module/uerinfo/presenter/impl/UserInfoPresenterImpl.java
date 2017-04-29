package com.tanchaoyin.demo.module.uerinfo.presenter.impl;

import com.tanchaoyin.demo.base.impl.BasePresenterImpl;
import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.module.uerinfo.model.UserInfoInteractor;
import com.tanchaoyin.demo.module.uerinfo.model.impl.UserInfoInteractorImpl;
import com.tanchaoyin.demo.module.uerinfo.presenter.UserInfoPresenter;
import com.tanchaoyin.demo.module.uerinfo.view.UserInfoView;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class UserInfoPresenterImpl extends BasePresenterImpl<UserInfoView,UserInfo> implements UserInfoPresenter {

    public UserInfoInteractor<UserInfo> userInfoUserInfoInteractor;

    public UserInfoPresenterImpl(UserInfoView view) {
        super(view);
        this.userInfoUserInfoInteractor = new UserInfoInteractorImpl();
    }


    @Override
    public void requsetUsers(String user) {
        this.userInfoUserInfoInteractor.userInfo(this,user);
    }

    @Override
    public void requestSuccess(UserInfo data) {
        super.requestSuccess(data);
        view.updaeUsers(data);
    }
}
