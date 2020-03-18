package com.lzywsgl.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.bus.domain.Car;
import com.lzywsgl.bus.domain.Check;
import com.lzywsgl.bus.domain.Customer;
import com.lzywsgl.bus.domain.Rent;
import com.lzywsgl.bus.mapper.CarMapper;
import com.lzywsgl.bus.mapper.CheckMapper;
import com.lzywsgl.bus.mapper.CustomerMapper;
import com.lzywsgl.bus.mapper.RentMapper;
import com.lzywsgl.bus.service.CheckService;
import com.lzywsgl.bus.vo.Checkvo;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.RandomUtils;
import com.lzywsgl.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Administrator
 * @title: CheckServiceImpl
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/17 22:00
 */
@Service
public class CheckServiceImpl implements CheckService {
    private final RentMapper rentMapper;
    private final CheckMapper checkMapper;
    private final CustomerMapper customerMapper;
    private final CarMapper carMapper;

    public CheckServiceImpl(RentMapper rentMapper, CheckMapper checkMapper, CustomerMapper customerMapper, CarMapper carMapper) {
        this.rentMapper = rentMapper;
        this.checkMapper = checkMapper;
        this.customerMapper = customerMapper;
        this.carMapper = carMapper;
    }

    @Override
    public Map<String, Object> initCheckFormData(String rentid) {
        // 查询出租单
        Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        // 查询客户
        Customer customer = this.customerMapper.selectByPrimaryKey(rent.getIdentity());
        // 查询车辆
        Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        // 组装Check
        Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_JC));
        check.setRentid(rentid);
        check.setCheckdate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rent", rent);
        map.put("customer", customer);
        map.put("car", car);
        map.put("check", check);
        return map;
    }

    @Override
    public void addCheck(Checkvo checkvo) {
        this.checkMapper.insertSelective(checkvo);
        // 更改出租单的状态
        Rent rent = this.rentMapper.selectByPrimaryKey(checkvo.getRentid());
        rent.setRentflag(SysConstast.RENT_BACK_TRUE);
        this.rentMapper.updateByPrimaryKeySelective(rent);
        // 更改汽车的状态
        Car car = new Car();
        car.setCarnumber(rent.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_FALSE);
        this.carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public DataGridView queryAllCheck(Checkvo checkvo) {
        Page<Object> page = PageHelper.startPage(checkvo.getPage(), checkvo.getLimit());
        List<Check> data = this.checkMapper.queryAllCheck(checkvo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void updateCheck(Checkvo checkvo) {
        this.checkMapper.updateByPrimaryKeySelective(checkvo);
    }
}
