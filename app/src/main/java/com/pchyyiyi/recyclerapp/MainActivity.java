package com.pchyyiyi.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.decoration.GroupedLinearItemDecoration;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.donkingliang.groupedadapter.layoutmanger.GroupedGridLayoutManager;
import com.donkingliang.groupedadapter.widget.StickyHeaderLayout;
import com.pchyyiyi.recyclerapp.adapter.CustomLinearItemDecoration;
import com.pchyyiyi.recyclerapp.adapter.NoFooterAdapter;
import com.pchyyiyi.recyclerapp.entity.TopGroupEntity;
import com.pchyyiyi.recyclerapp.entity.TopGroupModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private TextView tv_change;
    private RecyclerView recycler;
    private StickyHeaderLayout stickyLayout;
    private LinearLayoutManager layoutManager;
    private NoFooterAdapter adapter;

    private GroupedGridLayoutManager gridLayoutManager;
    private boolean mIsGrid = false;

    ArrayList<TopGroupEntity> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdatper();
        //设置是否吸顶。
        stickyLayout.setSticky(true);
    }

    private void initView(){
        tv_change  = (TextView) findViewById(R.id.tv_change);
        recycler = (RecyclerView) findViewById(R.id.rv_list);
        stickyLayout = (StickyHeaderLayout) findViewById(R.id.sticky_layout);

        tv_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsGrid) {
                    gridLayoutManager = new GroupedGridLayoutManager(mContext, 2, adapter);
                    mIsGrid = false;
                    recycler.setLayoutManager(gridLayoutManager);
                }else{
                    gridLayoutManager = new GroupedGridLayoutManager(mContext, 1, adapter);
                    mIsGrid = true;
                    recycler.setLayoutManager(gridLayoutManager);
                }
            }
        });
    }

    private void initAdatper() {
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        mData = TopGroupModel.getGroups(10, 7);
        adapter = new NoFooterAdapter(this, mData);
//        adapter = new NoFooterAdapter(this, null);
        adapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                      int groupPosition) {
                Toast.makeText(MainActivity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
                Log.e("eee", adapter.toString() + "  " + holder.toString());
            }
        });

        adapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                     int groupPosition, int childPosition) {
                Toast.makeText(MainActivity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
//        adapter.showEmptyView(true);

        gridLayoutManager = new GroupedGridLayoutManager(mContext, 1, adapter);
        mIsGrid = false;
        recycler.setLayoutManager(gridLayoutManager);

        //空白分割线，只需要设置分割线大小，不需要设置样式，divider为空则只添加间隔，不绘制样式
//        GroupedLinearItemDecoration itemDecoration = new GroupedLinearItemDecoration(adapter,
//                20, null,20,null,20,null);

        // 自定义分割线，可以根据需要设置每个item的分割线大小和样式
        CustomLinearItemDecoration itemDecoration = new CustomLinearItemDecoration(this,adapter);

        // 添加分割线
        recycler.addItemDecoration(itemDecoration);
        recycler.setAdapter(adapter);
    }


}
