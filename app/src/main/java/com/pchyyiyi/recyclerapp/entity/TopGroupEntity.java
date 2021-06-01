package com.pchyyiyi.recyclerapp.entity;

import java.util.ArrayList;

/**
 * @ClassName TopGroupEntity
 * @Description 组数据的实体类
 * @Author fayXxxx
 * @Date 2021/5/31 下午4:01
 * @Version 1.0
 */
public class TopGroupEntity {

    private String header;
    private String footer;
    private ArrayList<TopChildEntity> children;

    public TopGroupEntity(String header, String footer, ArrayList<TopChildEntity> children) {
        this.header = header;
        this.footer = footer;
        this.children = children;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public ArrayList<TopChildEntity> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TopChildEntity> children) {
        this.children = children;
    }
}
