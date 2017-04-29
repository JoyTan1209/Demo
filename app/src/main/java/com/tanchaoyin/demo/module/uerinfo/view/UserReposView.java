package com.tanchaoyin.demo.module.uerinfo.view;

import com.tanchaoyin.demo.base.BaseView;
import com.tanchaoyin.demo.entry.UserRepos;

import java.util.List;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public interface UserReposView extends BaseView {

    void updateUserRepos(List<UserRepos> userRepos);
}
