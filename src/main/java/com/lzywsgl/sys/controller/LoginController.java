package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.LogInfoService;
import com.lzywsgl.sys.service.UserService;
import com.lzywsgl.sys.utils.WebUtils;
import com.lzywsgl.sys.vo.LogInfovo;
import com.lzywsgl.sys.vo.Uservo;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
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
        String code = WebUtils.getHttpSession().getAttribute("captcha").toString();
        if (uservo.getCode().equals(code.trim().toLowerCase())) {
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
        } else {
            model.addAttribute("error", SysConstast.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }

    @RequestMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(Captcha.FONT_1); ;  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }
}
