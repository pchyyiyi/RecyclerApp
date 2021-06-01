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
public class MemberViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameView;
    private final TextView mMemoView;

    public MemberViewHolder(View itemView) {
        super(itemView);
        mNameView = itemView.findViewById(R.id.name);
        mMemoView = itemView.findViewById(R.id.memo);
    }

    public void update(Member member) {
        mNameView.setText(member.name);
        mMemoView.setText(member.memo);
    }
}
