package com.lzywsgl.bus.service;

import com.lzywsgl.bus.domain.Customer;
import com.lzywsgl.bus.vo.Rentvo;

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

}
