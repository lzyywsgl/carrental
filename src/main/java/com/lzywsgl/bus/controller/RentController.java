package com.lzywsgl.bus.controller;

import com.lzywsgl.bus.domain.Customer;
import com.lzywsgl.bus.service.CustomerService;
import com.lzywsgl.bus.service.RentService;
import com.lzywsgl.bus.vo.Rentvo;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.utils.RandomUtils;
import com.lzywsgl.sys.utils.ResultObj;
import com.lzywsgl.sys.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Administrator
 * @title: RentController
 * @projectName carrental
 * @description: 出租管理控制器
 * @date 2020/3/16 21:14
 */
@RestController
@RequestMapping("rent")
public class RentController {
    private final CustomerService customerService;
    private final RentService rentService;

    public RentController(RentService rentService, CustomerService customerService) {
        this.rentService = rentService;
        this.customerService = customerService;
    }

    /**
     * 检查身份证号是否存在
     */
    @RequestMapping("checkCustomerExist")
    public ResultObj checkCustomerExist(Rentvo rentvo) {
        Customer customer = customerService.queryCustomerByIdentity(rentvo.getIdentity());
        if (customer != null) {
            return ResultObj.STATUS_TRUE;
        } else {
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 初始化添加出租单的表单数据
     */
    @RequestMapping("initRentFrom")
    public Rentvo initRentFrom(Rentvo rentvo) {
        // 生成出租单好
        rentvo.setRentid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_CZ));
        // 设置出租时间
        rentvo.setBegindate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        // 设置操作员
        rentvo.setOpername(user.getRealname());
        return rentvo;
    }

    /**
     * 保存出租单信息
     */
    @RequestMapping("saveRent")
    public ResultObj saveRent(Rentvo rentvo) {
        try {
            // 设置创建时间
            rentvo.setCreatetime(new Date());
            // 设置归还状态
            rentvo.setRentflag(SysConstast.RENT_CAR_FALSE);

            // 保存
            this.rentService.addRent(rentvo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
