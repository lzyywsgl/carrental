package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.LogInfoService;
import com.lzywsgl.sys.service.UserService;
import com.lzywsgl.sys.utils.WebUtils;
import com.lzywsgl.sys.vo.LogInfovo;
import com.lzywsgl.sys.vo.Uservo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 用户登录控制器
 */
@Controller
@RequestMapping("login")
public class LoginController {
    private final UserService userService;
    private final LogInfoService logInfoService;
    @Autowired
    public LoginController(UserService userService, LogInfoService logInfoService) {
        this.userService = userService;
        this.logInfoService = logInfoService;
    }

    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "system/main/login";
    }


    /**
     * 登陆方法
     */
    @RequestMapping("login")
    public String login(Uservo uservo, Model model) {
        User user = this.userService.login(uservo);
        if (null != user) {
            //放到session
            WebUtils.getHttpSession().setAttribute("user", user);
            //记录登陆日志 向sys_login_log里面插入数据
            LogInfovo logInfovo = new LogInfovo();
            logInfovo.setLogintime(new Date());
            logInfovo.setLoginname(user.getLoginname() + "-" + user.getRealname());
            logInfovo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
            logInfoService.addLogInfo(logInfovo);
            return "system/main/index";
        } else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
            return "system/main/login";
        }

    }

}
