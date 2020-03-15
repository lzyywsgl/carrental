package com.lzywsgl.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.bus.domain.Car;
import com.lzywsgl.bus.mapper.CarMapper;
import com.lzywsgl.bus.service.CarService;
import com.lzywsgl.bus.vo.Carvo;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.utils.AppFileUtils;
import com.lzywsgl.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: CarServiceImpl
 * @projectName carrental
 * @description: 业务接口实现
 * @date 2020/3/13 21:06
 */
@Service
public class CarServiceImpl implements CarService {
    private final CarMapper carMapper;

    public CarServiceImpl(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public DataGridView queryAllCar(Carvo carvo) {
        Page<Object> page = PageHelper.startPage(carvo.getPage(), carvo.getLimit());
        List<Car> data = this.carMapper.queryAllCar(carvo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addCar(Carvo carvo) {
        this.carMapper.insertSelective(carvo);
    }

    @Override
    public void updateCar(Carvo carvo) {
        this.carMapper.updateByPrimaryKeySelective(carvo);
    }

    @Override
    public void deleteCar(String carnumber) {
        //先删除图片
        Car car = this.carMapper.selectByPrimaryKey(carnumber);
        // 如果不是默认图片就删除
        if (!car.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        // 删除数据库的数据
        this.carMapper.deleteByPrimaryKey(carnumber);
    }

    @Override
    public void deleteBatchCar(String[] ids) {
        for (String carnumber : ids) {
            this.carMapper.deleteByPrimaryKey(carnumber);
        }
    }

    @Override
    public Car queryAllCarByCarNumber(String carnumber) {
        return this.carMapper.selectByPrimaryKey(carnumber);
    }
}
