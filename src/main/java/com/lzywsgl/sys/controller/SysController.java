package com.lzywsgl.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName SysController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/4 19:51
 * @Version 1.0
 **/
@Controller
@RequestMapping("sys")
public class SysController {
    /**
     *
     * @return 菜单管理
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager() {
        return "system/menu/menuManager";
    }

    /**
     *
     * @return 左菜单管理
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft() {
        return "system/menu/menuLeft";
    }

    /**
     *
     * @return 右菜单管理
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight() {
        return "system/menu/menuRight";
    }

    /**
     * @return 角色管理
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager() {
        return "system/role/roleManager";
    }
}
