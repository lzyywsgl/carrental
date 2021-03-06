package com.lzywsgl.sys.vo;

import com.lzywsgl.sys.domain.Role;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName Rolevo
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/6 22:35
 * @Version 1.0
 **/
public class Rolevo extends Role {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接受多个角色id
    private Integer[] ids;

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
