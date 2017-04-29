package com.tanchaoyin.demo.module.uerinfo.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.socks.library.KLog;
import com.tanchaoyin.demo.R;
import com.tanchaoyin.demo.base.BaseAppCompatActivity;
import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.entry.UserRepos;
import com.tanchaoyin.demo.module.uerinfo.adapter.UsersAdapter;
import com.tanchaoyin.demo.module.uerinfo.presenter.UserInfoPresenter;
import com.tanchaoyin.demo.module.uerinfo.presenter.UserReposPresenter;
import com.tanchaoyin.demo.module.uerinfo.presenter.impl.UserInfoPresenterImpl;
import com.tanchaoyin.demo.module.uerinfo.presenter.impl.UserReposPresenterImpl;
import com.tanchaoyin.demo.module.uerinfo.view.UserInfoView;
import com.tanchaoyin.demo.module.uerinfo.view.UserReposView;
import com.tanchaoyin.demo.utils.ValueComparator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseAppCompatActivity<UserInfoPresenter> implements UserInfoView,UserReposView {

    @BindView(R.id.ed_user_name)
    EditText edUserName;

    @BindView(R.id.rec_user_list)
    RecyclerView recyUserList;

    private UsersAdapter usersAdapter;

    private UserReposPresenter userReposPresenter;

    private UserInfo userInfo;

    private LinkedHashMap<String, String> hashMap;

    @Override
    protected void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this );

        //设置布局管理器
        recyUserList.setLayoutManager(layoutManager);

        presenter = new UserInfoPresenterImpl(this);

        recyUserList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int start = ((LinearLayoutManager) recyUserList.getLayoutManager()).findFirstVisibleItemPosition();
                int end = ((LinearLayoutManager) recyUserList.getLayoutManager()).findLastVisibleItemPosition();
                //mListView.getChildCount()
                //可视范围内的数量
                KLog.e("start:",start+"");
                KLog.e("last:",end+"");
                for (int i = 0;i < recyUserList.getChildCount();i++){
                    if(start == -1){
                        continue;
                    }
                    if(start >= end){
                        break;
                    }
                    KLog.e("start----:",start+"");
                    ViewGroup parent = (ViewGroup) recyUserList.getChildAt(i);
                    TextView tv = (TextView) parent.findViewById(R.id.tv_language);
                    TextView tvId = (TextView) parent.findViewById(R.id.tv_id);
                    if (null != hashMap.get(tvId.getText().toString())) {
                        tv.setText(hashMap.get(tvId.getText().toString()));
                    }
                    start++;
                }
            }
        });
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_search)
    void search(View view) {
        edUserName.clearFocus();
        hashMap = new LinkedHashMap<String, String>();
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if (edUserName.getText().length() < 1) {
            Toast.makeText(this,"关键字不能为空！",Toast.LENGTH_SHORT).show();
        } else {
            presenter.requsetUsers(edUserName.getText().toString());
        }

    }

    @Override
    public void updaeUsers(UserInfo userInfo) {
        if (null != userInfo) {
            usersAdapter = new UsersAdapter(this,userInfo);
            recyUserList.setAdapter(usersAdapter);
            usersAdapter.notifyDataSetChanged();
            this.userInfo = userInfo;

            /**
             * 获取respos
             */
            getRespos();
        }
    }

    /**
     * getRespos
     */
    void getRespos() {

        if (null == userReposPresenter)
            userReposPresenter = new UserReposPresenterImpl(this);

        /**
         * 获取user repos
         */
        if (null != userInfo) {
            for (int i = 0; i < userInfo.items.size(); i++) {
                userReposPresenter.requestUserRepos(userInfo.items.get(i).repos_url);
            }
        }
    }

    @Override
    public void updateUserRepos(List<UserRepos> userRepos) {
        if (null != userRepos) {

            /**
             * 通过respos接口，获取项目列表
             *
             * 根据项目所使用开发语言判断偏好语言（使用该语言开发最多的）
             */

            Map<String, Integer> map = new HashMap<>();//新建一个map集合，用来保存重复的次数

            for(UserRepos obj: userRepos){

                //判断是否已经有该值，如有，则将次数加1
                if(map.containsKey(obj.language)){
                    map.put(obj.language, map.get(obj.language).intValue() + 1);
                }else{
                    map.put(obj.language, 1);
                }
            }

            /**
             * 将所得到的每个用户的项目语言集合排序
             *
             * 并找出使用频率最高的
             *
             */

            Map<String, Integer> sortedMap = ValueComparator.sortByValues(map);

            Set<String> keys = sortedMap.keySet();

            int i = 0;

            for (String key:keys) {
                if (i > 0)
                    break;
                if (i == 0)
                {
                    updateList(userRepos.get(0).owner.id,key);
                    hashMap.put(userRepos.get(0).owner.id,key);
                }
                i++;
            }
        }
    }

    void updateList(String key, String data) {
        int start = ((LinearLayoutManager) recyUserList.getLayoutManager()).findFirstVisibleItemPosition();
        int end = ((LinearLayoutManager) recyUserList.getLayoutManager()).findLastVisibleItemPosition();
        //mListView.getChildCount()
        //可视范围内的数量
        KLog.e("start:",start+"");
        KLog.e("last:",end+"");
        for (int i = 0;i < recyUserList.getChildCount();i++){
            if(start == -1){
                continue;
            }
            if(start >= end){
                break;
            }
            KLog.e("start----:",start+"");
            ViewGroup parent = (ViewGroup) recyUserList.getChildAt(i);
            TextView tv = (TextView) parent.findViewById(R.id.tv_language);
            TextView tvId = (TextView) parent.findViewById(R.id.tv_id);
            if (tvId.getText().toString().equals(key)) {
                tv.setText(data);
            }
            start++;
        }
    }
}
