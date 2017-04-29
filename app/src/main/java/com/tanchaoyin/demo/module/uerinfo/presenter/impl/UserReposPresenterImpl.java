package com.tanchaoyin.demo.module.uerinfo.presenter.impl;

import com.tanchaoyin.demo.base.impl.BasePresenterImpl;
import com.tanchaoyin.demo.entry.UserRepos;
import com.tanchaoyin.demo.module.uerinfo.model.UserInfoInteractor;
import com.tanchaoyin.demo.module.uerinfo.model.impl.UserInfoInteractorImpl;
import com.tanchaoyin.demo.module.uerinfo.presenter.UserReposPresenter;
import com.tanchaoyin.demo.module.uerinfo.view.UserReposView;

import java.util.List;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class UserReposPresenterImpl extends BasePresenterImpl<UserReposView,List<UserRepos>> implements UserReposPresenter {

    UserInfoInteractor<List<UserRepos>> userInfoInteractor;

    public UserReposPresenterImpl(UserReposView view) {
        super(view);
        this.userInfoInteractor = new UserInfoInteractorImpl();
    }

    @Override
    public void requestUserRepos(String url) {
        this.userInfoInteractor.suerRepos(this,url);
    }

    @Override
    public void requestSuccess(List<UserRepos> data) {
        super.requestSuccess(data);
        view.updateUserRepos(data);
    }
}
