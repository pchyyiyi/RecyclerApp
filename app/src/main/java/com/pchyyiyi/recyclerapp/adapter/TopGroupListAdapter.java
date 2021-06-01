package com.pchyyiyi.recyclerapp.adapter;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.pchyyiyi.recyclerapp.R;
import com.pchyyiyi.recyclerapp.entity.TopChildEntity;
import com.pchyyiyi.recyclerapp.entity.TopGroupEntity;

import java.util.ArrayList;

/**
 * @ClassName TopGroupListAdapter
 * @Description 这是普通的分组Adapter 每一个组都有头部、尾部和子项。
 * @Author fayXxxx
 * @Date 2021/5/31 下午4:07
 * @Version 1.0
 */
public class TopGroupListAdapter extends GroupedRecyclerViewAdapter {
    protected ArrayList<TopGroupEntity> mGroups;

    public TopGroupListAdapter(Context context, ArrayList<TopGroupEntity> groups) {
        super(context);
        mGroups = groups;
    }

    @Override
    public int getGroupCount() {
        return mGroups == null ? 0 : mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<TopChildEntity> children = mGroups.get(groupPosition).getChildren();
        return children == null ? 0 : children.size();
    }

    public void clear(){
        if(mGroups!=null){
            mGroups.clear();
        }
        notifyDataChanged();
    }

    public void setGroups(ArrayList<TopGroupEntity> groups){
        mGroups = groups;
        notifyDataChanged();
    }

    @Override
    public boolean hasHeader(int groupPosition) {
        return true;
    }

    @Override
    public boolean hasFooter(int groupPosition) {
        return true;
    }

    @Override
    public int getHeaderLayout(int viewType) {
        return R.layout.item_top_group_header;
    }

    @Override
    public int getFooterLayout(int viewType) {
        return R.layout.item_top_group_footer;
    }

    @Override
    public int getChildLayout(int viewType) {
        return R.layout.item_top_group_child;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {
        TopGroupEntity entity = mGroups.get(groupPosition);
        holder.setText(R.id.tv_header, entity.getHeader());
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
        TopGroupEntity entity = mGroups.get(groupPosition);
        holder.setText(R.id.tv_footer, entity.getFooter());
    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        TopChildEntity entity = mGroups.get(groupPosition).getChildren().get(childPosition);
        holder.setText(R.id.tv_child, entity.getChild());
    }

//    @Override
//    public View getEmptyView(ViewGroup parent) {
//        // 返回自定义空布局
//        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_empty_view, parent, false);
//        return view;
//    }

}
