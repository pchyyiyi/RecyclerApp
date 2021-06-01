package com.pchyyiyi.recyclerapp.timedesc;

import java.util.List;

/**
 * @ClassName OrderDtoGroup
 * @Description TODO
 * @Author fayXxxx
 * @Date 2021/6/1 上午10:43
 * @Version 1.0
 */
public class OrderDtoGroup {
    public String orderMonth;
    public List<OrderDto> orderDtoList;

    public OrderDtoGroup() {
    }

    public OrderDtoGroup(String ordermonth, List<OrderDto> orderDtolist) {
        this.orderMonth = ordermonth;
        this.orderDtoList = orderDtolist;
    }

    public String getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(String orderMonth) {
        this.orderMonth = orderMonth;
    }

    public List<OrderDto> getOrderDtoList() {
        return orderDtoList;
    }

    public void setOrderDtoList(List<OrderDto> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }
}
