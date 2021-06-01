package com.pchyyiyi.recyclerapp.timedesc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pchyyiyi.recyclerapp.R;
import com.pchyyiyi.recyclerapp.group.GroupRecyclerAdapter;

import java.util.List;

/**
 * @ClassName OrderGroupRecyclerAdapter
 * @Description TODO
 * @Author fayXxxx
 * @Date 2021/6/1 下午2:36
 * @Version 1.0
 */
public class OrderGroupRecyclerAdapter extends GroupRecyclerAdapter<OrderDtoGroup, OrderGroupViewHolder, OrderViewHolder> {
    private Context mContext;

    public OrderGroupRecyclerAdapter(Context context, List<OrderDtoGroup> groups) {
        super(groups);
        mContext = context;
    }

    @Override
    protected OrderGroupViewHolder onCreateGroupViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new OrderGroupViewHolder(layoutInflater.inflate(R.layout.item_time_desc_group, parent, false));
    }

    @Override
    protected OrderViewHolder onCreateChildViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new OrderViewHolder(layoutInflater.inflate(R.layout.item_time_desc_order, parent, false));
    }

    @Override
    protected void onBindGroupViewHolder(OrderGroupViewHolder holder, int groupPosition) {
        holder.update(getGroup(groupPosition));
    }

    @Override
    protected void onBindChildViewHolder(OrderViewHolder holder, int groupPosition, int childPosition) {
        holder.update(getGroup(groupPosition).orderDtoList.get(childPosition));
    }

    @Override
    protected int getChildCount(OrderDtoGroup group) {
        return group.orderDtoList.size();
    }
}
