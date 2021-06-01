package com.pchyyiyi.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pchyyiyi.recyclerapp.group.GroupItemDecoration;
import com.pchyyiyi.recyclerapp.group.GroupRecyclerAdapter;
import com.pchyyiyi.recyclerapp.group.OnChildClickListener;
import com.pchyyiyi.recyclerapp.group.OnGroupClickListener;
import com.pchyyiyi.recyclerapp.groupbean.MemberViewHolder;
import com.pchyyiyi.recyclerapp.groupbean.Team;
import com.pchyyiyi.recyclerapp.groupbean.TeamViewHolder;
import com.pchyyiyi.recyclerapp.timedesc.OrderDto;
import com.pchyyiyi.recyclerapp.timedesc.OrderDtoGroup;
import com.pchyyiyi.recyclerapp.timedesc.OrderEnum;
import com.pchyyiyi.recyclerapp.timedesc.OrderGroupRecyclerAdapter;
import com.pchyyiyi.recyclerapp.timedesc.OrderGroupViewHolder;
import com.pchyyiyi.recyclerapp.timedesc.OrderViewHolder;
import com.pchyyiyi.recyclerapp.util.AndroidLog;
import com.pchyyiyi.recyclerapp.util.Utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TimeDescGroupActivity extends AppCompatActivity {
    private static final String TAG = "recyclerApp";
    private RecyclerView recyclerView;

    List<OrderDtoGroup> mOrderDtoGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_desc_group);

        recyclerView = findViewById(R.id.recycler_view);

        initData();
        initAdapter();
    }


    protected void initData() {
        ArrayList<OrderDto> mlistorder = new ArrayList<>();
        for(int i = 0; i<5; i++){
            String amount = "1";
            String setBankName = "工商银行"+i;
            String setCreationTime = "20210412 13:44:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<4; i++){
            String amount = "2";
            String setBankName = "农业银行"+i;
            String setCreationTime = "20210812 01:22:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.TRANDFER);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<2; i++){
            String amount = "666";
            String setBankName = "建设银行"+i;
            String setCreationTime = "20220512 18:50:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.REPAYMENT);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<2; i++){
            String amount = "2";
            String setBankName = "浙商银行"+i;
            String setCreationTime = "20210519 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<2; i++){
            String amount = "33";
            String setBankName = "浦发银行"+i;
            String setCreationTime = "20180612 21:10:4"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.REPAYMENT);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<5; i++){
            String amount = "36";
            String setBankName = "中国银行"+i;
            String setCreationTime = "20200712 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<6; i++){
            String amount = "48";
            String setBankName = "上海银行"+i;
            String setCreationTime = "20210412 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.TRANDFER);
            mlistorder.add(mOrderDto);
        }
        for(int i = 0; i<2; i++){
            String amount = "623";
            String setBankName = "商业银行"+i;
            String setCreationTime = "20210623 16:20:5"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<9; i++){
            String amount = "59";
            String setBankName = "成都农商银行"+i;
            String setCreationTime = "20210512 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<4; i++){
            String amount = "66";
            String setBankName = "南充商业银行"+i;
            String setCreationTime = "20180412 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.TRANDFER);
            mlistorder.add(mOrderDto);
        }
        for(int i = 0; i<9; i++){
            String amount = "27";
            String setBankName = "某某银行"+i;
            String setCreationTime = "20190412 11:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<5; i++){
            String amount = "89";
            String setBankName = "某市某银行"+i;
            String setCreationTime = "20200413 17:09:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.TRANDFER);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<5; i++){
            String amount = "39";
            String setBankName = "南充商业银行"+i;
            String setCreationTime = "20200413 18:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }

        for(int i = 0; i<1; i++){
            String amount = "39";
            String setBankName = "南充商业银行"+i;
            String setCreationTime = "20210613 18:00:0"+i;
            OrderDto mOrderDto = new OrderDto(amount, setBankName, setCreationTime, OrderEnum.OrderType.LOAD);
            mlistorder.add(mOrderDto);
        }
//        AndroidLog.i(TAG, "====未排序处理====");
//        for(OrderDto ss :  mlistorder){
//            AndroidLog.i(TAG, ss.toString());
//        }

        Collections.sort(mlistorder);
        AndroidLog.i(TAG, "====排序后111====");
        for(OrderDto ss :  mlistorder){
            AndroidLog.i(TAG, ss.toString());
        }

//        sortData(mlistorder);
//        AndroidLog.i(TAG, "====排序后222====");
//        for(OrderDto ss :  mlistorder){
//            AndroidLog.i(TAG, ss.toString());
//        }

        System.out.print("TimeDesc 按月分组排序后\n");
        initTimeDate();
        mOrderDtoGroup = changeListToGroup(mlistorder);
        if(mOrderDtoGroup!=null && mOrderDtoGroup.size()>0){
            System.out.print("TimeDesc size - "+mOrderDtoGroup.size()+"\n");
            for(int i =0; i<mOrderDtoGroup.size(); i++){
                String mounth = mOrderDtoGroup.get(i).getOrderMonth();
                System.out.print("TimeDesc mounth - "+mounth+"\n");
                List<OrderDto> orderDtoList = mOrderDtoGroup.get(i).getOrderDtoList();
                for(OrderDto orderdd: orderDtoList){
                    System.out.print("TimeDesc OrderDto - "+orderdd.toString()+"\n");
                }
            }
        }
    }

    /**
     * List转换为Group，为了适应之前的代码
     */
    private List<OrderDtoGroup> changeListToGroup(List<OrderDto> orderDtoList) {
        RecyclerApplication.currentMonth = "000000";
        List<OrderDtoGroup> orderDtoGrouplist = new ArrayList<>();

        if (orderDtoList != null && orderDtoList.size()>0) {
            OrderDtoGroup orderDtoGroup = null;
            List<OrderDto> orderDtolist = null;
            for (int i = 0; i < orderDtoList.size(); i++) {
                OrderDto orderDto = orderDtoList.get(i);
                String month = getYearMonth(orderDto.getCreationTime());
                if (!month.equals(RecyclerApplication.currentMonth)) {
                    if(orderDtoGroup!=null){
                        if(orderDtolist!=null){
                            orderDtoGroup.setOrderDtoList(orderDtolist);
                        }
                        orderDtoGrouplist.add(orderDtoGroup);
                    }
                    //换新的group
                    RecyclerApplication.currentMonth = month;
                    orderDtoGroup = new OrderDtoGroup();
                    orderDtoGroup.setOrderMonth(month);
                    orderDtolist = new ArrayList<>();
                    orderDtolist.add(orderDto);
                }else{
                    //和上一个属于用一个group
                    if(orderDtolist!=null){
                        orderDtolist.add(orderDto);
                    }
                }
            }
            //最后一组也需要加上
            if(orderDtoGroup!=null){
                if(orderDtolist!=null){
                    orderDtoGroup.setOrderDtoList(orderDtolist);
                }
                orderDtoGrouplist.add(orderDtoGroup);
            }
            return orderDtoGrouplist;
        } else {
            return null;
        }

    }
    private int currentyear;
    private int currentmonth;
    private int currentday;

    /**
     * 获取当时时间的年、月、日
     */
    private void initTimeDate(){
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(new Date());

        currentyear = currentCalendar.get(Calendar.YEAR);
        currentmonth = currentCalendar.get(Calendar.MONTH);
        currentday = currentCalendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据时间获取xxxx年xx月
     * @param date
     *     格式如：20200413 18:00:00
     * @return
     */
    private String getYearMonth(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));

        if(currentyear == year && month == currentmonth + 1){
            return "本月";
        }

        return date.substring(0,4) + "年"+date.substring(4,6) + "月";
    }

    /**
     * 初始化适配器
     */
    private void initAdapter(){
//        final LayoutInflater layoutInflater = LayoutInflater.from(this);
//        final GroupRecyclerAdapter<OrderDtoGroup, OrderGroupViewHolder, OrderViewHolder> recyclerAdapter =
//                new GroupRecyclerAdapter<OrderDtoGroup, OrderGroupViewHolder, OrderViewHolder>(mOrderDtoGroup) {
//                    @Override
//                    protected OrderGroupViewHolder onCreateGroupViewHolder(ViewGroup parent) {
//                        return new OrderGroupViewHolder(layoutInflater.inflate(R.layout.item_time_desc_group, parent, false));
//                    }
//
//                    @Override
//                    protected OrderViewHolder onCreateChildViewHolder(ViewGroup parent) {
//                        return new OrderViewHolder(layoutInflater.inflate(R.layout.item_time_desc_order, parent, false));
//                    }
//
//                    @Override
//                    protected void onBindGroupViewHolder(OrderGroupViewHolder holder, int groupPosition) {
//                        holder.update(getGroup(groupPosition));
//                    }
//
//                    @Override
//                    protected void onBindChildViewHolder(OrderViewHolder holder, int groupPosition, int childPosition) {
//                        holder.update(getGroup(groupPosition).orderDtoList.get(childPosition));
//                    }
//
//                    @Override
//                    protected int getChildCount(OrderDtoGroup group) {
//                        return group.orderDtoList.size();
//                    }
//                };

        OrderGroupRecyclerAdapter recyclerAdapter = new OrderGroupRecyclerAdapter(this, mOrderDtoGroup);
        //setLayoutManager不加这句不显示
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        GroupItemDecoration decoration = new GroupItemDecoration(recyclerAdapter);
        decoration.setGroupDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_height_16_dp, null));
        decoration.setTitleDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_height_1_px, null));
        decoration.setChildDivider(ResourcesCompat.getDrawable(getResources(), R.drawable.simple_divider_white_header, null));
        recyclerView.addItemDecoration(decoration);

        recyclerAdapter.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public void onGroupItemClick(View itemView, int groupPosition) {
                showToast(recyclerAdapter.getGroup(groupPosition).orderMonth);
            }
        });
        recyclerAdapter.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public void onChildClick(View itemView, int groupPosition, int childPosition) {
                OrderDtoGroup team = recyclerAdapter.getGroup(groupPosition);
                showToast(team.orderMonth + ": " +team.orderDtoList.get(childPosition).creationTime);
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

//    /**
//     * 排序
//     * @param mList
//     */
//    private void sortData(ArrayList<OrderDto> mList) {
//        Collections.sort(mList, new Comparator<OrderDto>() {
//            /**
//             *
//             * @param lhs
//             * @param rhs
//             * @return an integer < 0 if lhs is less than rhs, 0 if they are
//             *         equal, and > 0 if lhs is greater than rhs,比较数据大小时,这里比的是时间
//             */
//            @Override
//            public int compare(OrderDto lhs, OrderDto rhs) {
//                if(TextUtils.isEmpty(lhs.creationTime) || TextUtils.isEmpty(rhs.creationTime)){
//                    return 0;
//                }
//                int result = 0;
//                try {
//                    AndroidLog.i("compare "+lhs.creationTime);
//                    Date date1 = Utility.stringToDate(lhs.creationTime);
//                    Date date2 = Utility.stringToDate(rhs.creationTime);
//
//                    if (date1.after(date2)) {
//                        result = -1;
//                    } else if (date1.before(date2)) {
//                        result = 1;
//                    } else if (date1.equals(date2)) {
//                        result = 0;
//                    }
//                }catch (Exception e){
//
//                }
//                return result;
//            }
//        });
//    }

}