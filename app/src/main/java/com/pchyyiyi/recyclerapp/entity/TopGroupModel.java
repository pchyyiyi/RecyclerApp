package com.pchyyiyi.recyclerapp.entity;

import java.util.ArrayList;

/**
 * @ClassName TopGroupModel
 * @Description TODO
 * @Author fayXxxx
 * @Date 2021/5/31 下午4:03
 * @Version 1.0
 */
public class TopGroupModel {
    /**
     * 获取组列表数据
     *
     * @param groupCount    组数量
     * @param childrenCount 每个组里的子项数量
     * @return
     */
    public static ArrayList<TopGroupEntity> getGroups(int groupCount, int childrenCount) {
        ArrayList<TopGroupEntity> groups = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            ArrayList<TopChildEntity> children = new ArrayList<>();
            for (int j = 0; j < childrenCount; j++) {
                children.add(new TopChildEntity("第" + (i + 1) + "组第" + (j + 1) + "项"));
            }
            groups.add(new TopGroupEntity("第" + (i + 1) + "组头部",
                    "第" + (i + 1) + "组尾部", children));
        }
        return groups;
    }
}
