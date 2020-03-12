package com.lzywsgl.bus.service;

import com.lzywsgl.bus.vo.Customervo;
import com.lzywsgl.sys.utils.DataGridView;

/**
 * @author Administrator
 * @title: CustomerService
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/12 15:04
 */
public interface CustomerService {
    /**
     * 查询所有客户
     */
    DataGridView queryAllCustomer(Customervo customervo);

    /**
     * 添加客户
     */
    void addCustomer(Customervo customervo);

    /**
     * 修改客户
     */
    void updateCustomer(Customervo customervo);

    /**
     * 根据id删除客户
     */
    void deleteCustomer(String identity);

    /**
     * 批量删除客户
     */
    void deleteBatchCustomer(String[] identities);

}
