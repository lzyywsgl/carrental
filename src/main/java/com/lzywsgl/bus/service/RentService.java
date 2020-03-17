package com.lzywsgl.bus.service;

import com.lzywsgl.bus.domain.Customer;
import com.lzywsgl.bus.domain.Rent;
import com.lzywsgl.bus.vo.Rentvo;
import com.lzywsgl.sys.utils.DataGridView;

/**
 * @author Administrator
 * @title: RentService
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/16 21:08
 */
public interface RentService {
    /**
     * 保存出租单信息
     */
    void addRent(Rentvo rentvo);

    /**
     * 查询
     */
    DataGridView queryAllRent(Rentvo rentvo);

    /**
     * 修改出租单
     */
    void updateRent(Rentvo rentvo);

    /**
     * 删除出租单
     */
    void deleteRent(String rentid);

    /**
     * 根据出租单号查询出租单信息
     */
    Rent queryRentByRentId(String rentid);
}
