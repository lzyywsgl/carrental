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

    /**
     * @return 车辆管理
     */
    @RequestMapping("toCarManager")
    public String toCarManager() {
        return "business/car/carManager";
    }

    /**
     * @return 出租管理
     */

    @RequestMapping("toRentCarManager")
    public String toRentCarManager() {
        return "business/rent/rentCarManager";
    }

    /**
     * @return 出租单管理
     */
    @RequestMapping("toRentManager")
    public String toRentManager() {
        return "business/rent/rentManager";
    }
    /**
     * @return 汽车入库管理
     */
    @RequestMapping("toCheckCarManager")
    public String toCheckCarManager() {
        return "business/check/checkCarManager";
    }
}
