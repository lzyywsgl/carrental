package com.lzywsgl.bus.vo;

import com.lzywsgl.bus.domain.Car;

/**
 * @author Administrator
 * @title: Carvo
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/13 20:59
 */
public class Carvo extends Car {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接收多个id
    private String[] ids;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
