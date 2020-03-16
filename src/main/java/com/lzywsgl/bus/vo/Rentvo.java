package com.lzywsgl.bus.vo;

import com.lzywsgl.bus.domain.Rent;

/**
 * @author Administrator
 * @title: Rentvo
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/16 21:06
 */
public class Rentvo extends Rent {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

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
}
