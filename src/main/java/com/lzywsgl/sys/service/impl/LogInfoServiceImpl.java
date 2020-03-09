package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.domain.Loginfo;
import com.lzywsgl.sys.mapper.LoginfoMapper;
import com.lzywsgl.sys.service.LogInfoService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.LogInfovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName LogInfoServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/9 17:09
 * @Version 1.0
 **/
@Service
public class LogInfoServiceImpl implements LogInfoService {
    private final LoginfoMapper loginfoMapper;

    @Autowired
    public LogInfoServiceImpl(LoginfoMapper loginfoMapper) {
        this.loginfoMapper = loginfoMapper;
    }

    @Override
    public DataGridView queryAllLogInfo(LogInfovo logInfovo) {
        Page<Object> page = PageHelper.startPage(logInfovo.getPage(), logInfovo.getLimit());
        List<Loginfo> data = this.loginfoMapper.queryAllLogInfo(logInfovo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addLogInfo(LogInfovo logInfovo) {
        this.loginfoMapper.insertSelective(logInfovo);
    }

    @Override
    public void deleteLogInfo(Integer lofInfoid) {
        this.loginfoMapper.deleteByPrimaryKey(lofInfoid);
    }

    @Override
    public void deletebatchLogInfo(Integer[] ids) {
        for (Integer integer : ids) {
            this.deleteLogInfo(integer);
        }
    }
}
