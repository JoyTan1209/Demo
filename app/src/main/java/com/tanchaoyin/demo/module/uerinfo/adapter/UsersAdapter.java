package com.tanchaoyin.demo.module.uerinfo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tanchaoyin.demo.R;
import com.tanchaoyin.demo.entry.UserInfo;
import com.tanchaoyin.demo.utils.CropCircleTransformation;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private Context context;

    private UserInfo userInfo;

    public UsersAdapter(Context context, UserInfo userInfo) {
        this.context = context;
        this.userInfo = userInfo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tvTitle.setText(userInfo.items.get(position).login);

        Glide.with(context).load(userInfo.items.get(position).avatar_url)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.imgAvatar);

        holder.tvId.setText(userInfo.items.get(position).id);

    }

    @Override
    public int getItemCount()
    {
        return userInfo.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.tv_name)
        TextView tvTitle;

        @BindView(R.id.img_avatar)
        ImageView imgAvatar;

        @BindView(R.id.tv_language)
        TextView tvLanguage;

        @BindView(R.id.tv_id)
        TextView tvId;

        public MyViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
