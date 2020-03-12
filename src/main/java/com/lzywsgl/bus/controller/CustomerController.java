package com.lzywsgl.bus.controller;

import com.lzywsgl.bus.service.CustomerService;
import com.lzywsgl.bus.vo.Customervo;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Administrator
 * @title: CustomerController
 * @projectName carrental
 * @description: 客户管理控制器
 * @date 2020/3/12 15:33
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 加载客户列表返回DataGridView
     */
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(Customervo customervo) {
        return this.customerService.queryAllCustomer(customervo);
    }

    /**
     * 添加客户
     */
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(Customervo customervo) {
        try {
            customervo.setCreatetime(new Date());
            this.customerService.addCustomer(customervo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改客户
     */
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(Customervo customervo) {
        try {
            this.customerService.updateCustomer(customervo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 根据id删除客户
     */
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(Customervo customervo) {
        try {
            this.customerService.deleteCustomer(customervo.getIdentity());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    /**
     * 批量删除客户
     */
    @RequestMapping("deleteBatchCustomer")
    public ResultObj deleteBatchCustomer(Customervo customervo) {
        try {
            this.customerService.deleteBatchCustomer(customervo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
