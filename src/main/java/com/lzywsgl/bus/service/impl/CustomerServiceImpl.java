package com.lzywsgl.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.bus.domain.Customer;
import com.lzywsgl.bus.mapper.CustomerMapper;
import com.lzywsgl.bus.service.CustomerService;
import com.lzywsgl.bus.vo.Customervo;
import com.lzywsgl.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: CustomerServiceImpl
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/12 15:16
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public DataGridView queryAllCustomer(Customervo customervo) {
        Page<Object> page = PageHelper.startPage(customervo.getPage(), customervo.getLimit());
        List<Customer> data = this.customerMapper.queryAllCustomer(customervo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addCustomer(Customervo customervo) {
        this.customerMapper.insertSelective(customervo);
    }

    @Override
    public void updateCustomer(Customervo customervo) {
        this.customerMapper.updateByPrimaryKeySelective(customervo);
    }

    @Override
    public void deleteCustomer(String identity) {
        this.customerMapper.deleteByPrimaryKey(identity);
    }

    @Override
    public void deleteBatchCustomer(String[] identities) {
        for (String identity : identities) {
            this.customerMapper.deleteByPrimaryKey(identity);
        }
    }

    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return this.customerMapper.selectByPrimaryKey(identity);
    }

    @Override
    public List<Customer> queryAllCustomerForList(Customervo customervo) {
        return this.customerMapper.queryAllCustomer(customervo);
    }
}
