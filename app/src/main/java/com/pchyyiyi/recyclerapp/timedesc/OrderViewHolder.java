package com.pchyyiyi.recyclerapp.timedesc;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pchyyiyi.recyclerapp.R;


/**
 * @ClassName OrderViewHolder
 * @Description TODO
 * @Author fayxx
 * @Date 2021/6/1 下午1:56
 * @Version 1.0
 */
public class OrderViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameView;
    private final TextView mdateView;
    private final TextView mamountView;
    private final TextView mtypeView;

    public OrderViewHolder(View itemView) {
        super(itemView);
        mNameView = itemView.findViewById(R.id.tv_bankname);
        mdateView = itemView.findViewById(R.id.tv_date);
        mamountView = itemView.findViewById(R.id.tv_amount);
        mtypeView = itemView.findViewById(R.id.tv_type);
    }

    public void update(OrderDto order) {
        mNameView.setText(order.getBankName());
        mdateView.setText(order.getCreationTime());
        mamountView.setText(order.getAmount());
        OrderEnum.OrderType type = order.getType();
        if(type == OrderEnum.OrderType.LOAD){
            mtypeView.setText("圈存");
        }else if(type == OrderEnum.OrderType.TRANDFER){
            mtypeView.setText("转账");
        }else if(type == OrderEnum.OrderType.REPAYMENT){
            mtypeView.setText("还款");
        }else{
            mtypeView.setText("其他");
        }

    }
}
