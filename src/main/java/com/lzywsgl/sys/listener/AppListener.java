package com.lzywsgl.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Administrator
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        //取到ServletContext
        ServletContext context = arg0.getServletContext();
        context.setAttribute("lzywsgl", context.getContextPath());
        System.out.println("---------Servlet容器创建成功 ctx被放到ServletContext作用域-------");
    }
}
