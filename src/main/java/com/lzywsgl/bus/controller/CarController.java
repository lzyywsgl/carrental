package com.lzywsgl.bus.controller;

import com.lzywsgl.bus.service.CarService;
import com.lzywsgl.bus.vo.Carvo;
import com.lzywsgl.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @title: CarController
 * @projectName carrental
 * @description: 车辆管理控制器
 * @date 2020/3/13 21:19
 */
@RestController
@RequestMapping("car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * 加载车辆列表返回DataGridView
     */
    @RequestMapping("loadAllCar")
    public DataGridView loadAllCar(Carvo carvo) {
        return this.carService.queryAllCar(carvo);
    }
}
