package com.lzywsgl.sys.mapper;

import com.lzywsgl.sys.domain.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 查询所有菜单
     *
     * @return 查询菜单
     */
    List<Menu> queryAllMenu(Menu menu);
}