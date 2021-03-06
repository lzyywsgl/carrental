package com.lzywsgl.bus.service;

import com.lzywsgl.bus.domain.Car;
import com.lzywsgl.bus.vo.Carvo;
import com.lzywsgl.sys.utils.DataGridView;

/**
 * @author Administrator
 * @title: CarService
 * @projectName carrental
 * @description: 车辆管理的服务
 * @date 2020/3/13 21:03
 */
public interface CarService {
    /**
     * 查询所有车辆
     */
    DataGridView queryAllCar(Carvo carvo);

    /**
     * 添加车辆
     */
    void addCar(Carvo carvo);

    /**
     * 修改车辆
     */
    void updateCar(Carvo carvo);

    /**
     * 删除车辆
     */
    void deleteCar(String carnumber);

    /**
     * 批量删除车辆
     */
    void deleteBatchCar(String[] carnumbers);

    /**
     * 根据车牌好查询车辆
     */
    Car queryAllCarByCarNumber(String carnumber);
}
