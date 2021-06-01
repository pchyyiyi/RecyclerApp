package com.pchyyiyi.recyclerapp.timedesc;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pchyyiyi.recyclerapp.R;


/**
 * @ClassName OrderGroupViewHolder
 * @Description TODO
 * @Author fayxx
 * @Date 2021/6/1 下午1:56
 * @Version 1.0
 */
public class OrderGroupViewHolder extends RecyclerView.ViewHolder {
    private final TextView mgroupView;

    public OrderGroupViewHolder(View itemView) {
        super(itemView);
        mgroupView = itemView.findViewById(R.id.groupname);
    }

    public void update(OrderDtoGroup team) {
        mgroupView.setText(team.orderMonth);
    }
}
