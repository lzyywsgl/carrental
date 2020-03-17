package com.lzywsgl.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.bus.domain.Car;
import com.lzywsgl.bus.domain.Rent;
import com.lzywsgl.bus.mapper.CarMapper;
import com.lzywsgl.bus.mapper.RentMapper;
import com.lzywsgl.bus.service.RentService;
import com.lzywsgl.bus.vo.Rentvo;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.utils.DataGridView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: RentServiceImpl
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/16 21:10
 */
@Service
public class RentServiceImpl implements RentService {

    private final RentMapper rentMapper;
    private  final CarMapper carMapper;

    public RentServiceImpl(RentMapper rentMapper, CarMapper carMapper) {
        this.rentMapper = rentMapper;
        this.carMapper = carMapper;
    }

    @Override
    public void addRent(Rentvo rentvo) {
        this.rentMapper.insertSelective(rentvo);
        // 更改车辆的出租状态
        Car car = new Car();
        car.setCarnumber(rentvo.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_TRUE);
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public DataGridView queryAllRent(Rentvo rentvo) {
        Page<Object> page = PageHelper.startPage(rentvo.getPage(), rentvo.getLimit());
        List<Rent> data = this.rentMapper.queryAllRent(rentvo);
        return new DataGridView(page.getTotal(), data);
    }
}
