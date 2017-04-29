package com.tanchaoyin.demo.base;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public interface BasePresenter {

    void onResume();

    void onStart();

    void onPause();

    void onStop();

    void onDestroy();
}
