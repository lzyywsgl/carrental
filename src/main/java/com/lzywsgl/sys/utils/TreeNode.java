package com.lzywsgl.sys.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName TreeNode
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/2 21:27
 * @Version 1.0
 **/
public class TreeNode {
    private Integer id;
    @JsonProperty("parentId")
    private Integer pid;

    // 复选树必要属性
    private String checkArr = "0";//选中就是1
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private String target;
    private List<TreeNode> children = new ArrayList<>();

    /**
     * 复选树的使用
     * @param id id
     * @param pid id
     * @param title 标题
     * @param spread 分页
     * @param checkArr 复选树属性
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread, String checkArr) {
        super();
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 首页左边导航树的构造器
     */
    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread, String target) {
        super();
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
        this.target = target;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
