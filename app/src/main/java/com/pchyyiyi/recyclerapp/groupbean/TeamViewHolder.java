/*
 * Copyright (c) 2017. Xi'an iRain IOT Technology service CO., Ltd (ShenZhen). All Rights Reserved.
 */

package com.pchyyiyi.recyclerapp.groupbean;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pchyyiyi.recyclerapp.R;


/**
 * @author 黄浩杭 (msdx.android@qq.com)
 * @since 2017-09-07
 */
public class TeamViewHolder extends RecyclerView.ViewHolder {
    private final TextView mTitleView;

    public TeamViewHolder(View itemView) {
        super(itemView);
        mTitleView = itemView.findViewById(R.id.title);
    }

    public void update(Team team) {
        mTitleView.setText(team.title);
    }
}
