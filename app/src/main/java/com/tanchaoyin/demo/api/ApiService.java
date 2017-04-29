package com.tanchaoyin.demo.api;

import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.entry.UserRepos;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public interface ApiService {

    /**
     * Users
     *
     * @param user
     * @return
     */
    @GET(ApiConstants.USER_INFO)
    Observable<UserInfo> userInfo(@Query("q") String user);

    @GET()
    Observable<List<UserRepos>> userRepos(@Url String url);
}
