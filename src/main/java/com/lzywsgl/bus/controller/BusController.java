package com.lzywsgl.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @title: BusController
 * @projectName carrental
 * @description: 业务控制器
 * @date 2020/3/12 15:29
 */
@Controller
@RequestMapping("bus")
public class BusController {
    /**
     * @return 客户管理
     */
    @RequestMapping("toCustomerManager")
    public String toCustomerManager() {
        return "business/customer/customerManager";
    }
}
