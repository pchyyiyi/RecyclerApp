package com.pchyyiyi.recyclerapp.timedesc;

import android.text.TextUtils;


import com.pchyyiyi.recyclerapp.util.Utility;

import java.util.Date;

/**
 * @ClassName OrderDto
 * @Description TODO
 * @Author fayxx
 * @Date 2021/5/27 下午12:56
 * @Version 1.0
 */
public class OrderDto implements Comparable<OrderDto>{
    private String bankName;
    private OrderEnum.OrderType type;
    public String creationTime;
    private String  amount;


    public OrderDto() {
    }

    public OrderDto(String amount, String bankName, String creationTime,
                    OrderEnum.OrderType type) {
        super();
        this.bankName = bankName;
        this.creationTime = creationTime;
        this.type = type;
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public OrderEnum.OrderType getType() {
        return type;
    }

    public void setType(OrderEnum.OrderType type) {
        this.type = type;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "bankName='" + bankName + '\'' +
                ", type=" + type +
                ", creationTime='" + creationTime + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    @Override
    public int compareTo(OrderDto other) {
        if(TextUtils.isEmpty(creationTime) || TextUtils.isEmpty(other.creationTime)){
            return 0;
        }
        int result = 0;
        try {
            Date date1 = Utility.stringToDate(creationTime);
            Date date2 = Utility.stringToDate(other.creationTime);

            if (date1.after(date2)) {
                result = -1;
            } else if (date1.before(date2)) {
                result = 1;
            } else if (date1.equals(date2)) {
                result = 0;
            }
        }catch (Exception e){

        }
        return result;
    }
}
