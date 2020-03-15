package com.lzywsgl.bus.controller;

import com.lzywsgl.bus.domain.Car;
import com.lzywsgl.bus.service.CarService;
import com.lzywsgl.bus.vo.Carvo;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.utils.AppFileUtils;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    /**
     * 添加车辆
     */
    @RequestMapping("addCar")
    public ResultObj addCar(Carvo carvo) {
        try {
            carvo.setCreatetime(new Date());
            //如果不是默认图片就去掉图片的_temp的后缀
            if (!carvo.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
                String filePath = AppFileUtils.updateFileName(carvo.getCarimg(), SysConstast.FILE_UPLOAD_TEMP);
                carvo.setCarimg(filePath);
            }
            this.carService.addCar(carvo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改车辆
     */
    @RequestMapping("updateCar")
    public ResultObj updateCar(Carvo carvo) {
        try {
            String carimg = carvo.getCarimg();
            if (carimg.endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
                String filePath = AppFileUtils.updateFileName(carvo.getCarimg(), SysConstast.FILE_UPLOAD_TEMP);
                carvo.setCarimg(filePath);
                // 把原来的删除
                Car car = this.carService.queryAllCarByCarNumber(carvo.getCarnumber());
                AppFileUtils.removeFileByPath(car.getCarimg());
            }
            this.carService.updateCar(carvo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除车辆
     */
    @RequestMapping("deleteCar")
    public ResultObj deleteCar(Carvo carvo) {
        try {
            this.carService.deleteCar(carvo.getCarnumber());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除车辆
     */
    @RequestMapping("deleteBatchCar")
    public ResultObj deleteBatchCar(Carvo carvo) {
        try {
            this.carService.deleteBatchCar(carvo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
