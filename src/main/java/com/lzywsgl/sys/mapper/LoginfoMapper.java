package com.lzywsgl.sys.mapper;

import com.lzywsgl.sys.domain.Loginfo;

import java.util.List;

public interface LoginfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginfo record);

    int insertSelective(Loginfo record);

    Loginfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginfo record);

    int updateByPrimaryKey(Loginfo record);

    /**
     * 查询日志
     */
    List<Loginfo> queryAllLogInfo(Loginfo loginfo);
}