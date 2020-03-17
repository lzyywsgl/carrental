package com.lzywsgl.bus.controller;

import com.lzywsgl.bus.domain.Rent;
import com.lzywsgl.bus.mapper.CheckMapper;
import com.lzywsgl.bus.mapper.RentMapper;
import com.lzywsgl.bus.service.CarService;
import com.lzywsgl.bus.service.CheckService;
import com.lzywsgl.bus.service.RentService;
import com.lzywsgl.bus.vo.Carvo;
import com.lzywsgl.bus.vo.Checkvo;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author Administrator
 * @title: CheckController
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/17 22:21
 */
@RestController
@RequestMapping("check")
public class CheckController {
    private final RentService rentService;
    private final CheckService checkService;

    public CheckController(CheckService checkService, RentService rentService) {
        this.checkService = checkService;
        this.rentService = rentService;
    }

    /**
     * 根据出租单号加载检查单号的表单数据
     */
    @RequestMapping("initCheckFormData")
    public Map<String, Object> initCheckFormData(String rentid) {
        return this.checkService.initCheckFormData(rentid);
    }

    /**
     * 根据出租单号查询出租单信息
     */
    @RequestMapping("checkRentExist")
    public Rent checkRentExist(String rentid) {
        Rent rent = this.rentService.queryRentByRentId(rentid);
        return rent;
    }

    /**
     * 保存检查单数据
     */
    @RequestMapping("saveCheck")
    public ResultObj saveCheck(Checkvo checkvo) {
        try {
            checkvo.setCreatetime(new Date());
            this.checkService.addCheck(checkvo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
