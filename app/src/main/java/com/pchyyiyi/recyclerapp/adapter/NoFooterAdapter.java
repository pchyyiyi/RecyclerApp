package com.pchyyiyi.recyclerapp.adapter;



import android.content.Context;

import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.pchyyiyi.recyclerapp.entity.TopGroupEntity;

import java.util.ArrayList;

/**
 * @ClassName NoFooterAdapter
 * @Description 没有尾部的Adapter(用来做吸顶效果)
 * @Author fayXxxx
 * @Date 2021/5/31 下午4:12
 * @Version 1.0
 */
public class NoFooterAdapter extends TopGroupListAdapter {

    public NoFooterAdapter(Context context, ArrayList<TopGroupEntity> groups) {
        super(context, groups);
    }

    /**
     * 返回false表示没有组尾
     *
     * @param groupPosition
     * @return
     */
    @Override
    public boolean hasFooter(int groupPosition) {
        return false;
    }

    /**
     * 当hasFooter返回false时，这个方法不会被调用。
     *
     * @return
     */
    @Override
    public int getFooterLayout(int viewType) {
        return 0;
    }

    /**
     * 当hasFooter返回false时，这个方法不会被调用。
     *
     * @param holder
     * @param groupPosition
     */
    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {

    }
}