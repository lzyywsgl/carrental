package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.mapper.MenuMapper;
import com.lzywsgl.sys.service.MenuService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Menuvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> queryAllMenuForList(Menuvo menuvo) {
        return menuMapper.queryAllMenu(menuvo);
    }

    /**
     *后期权限管理完成后再改
     */
    @Override
    public List<Menu> queryMenuByUserIdForList(Menuvo menuvo, Integer userId) {
        return null;
    }

    @Override
    public DataGridView queryAllMenu(Menuvo menuvo) {
        Page<Object> page = PageHelper.startPage(menuvo.getPage(), menuvo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuvo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addMenu(Menuvo menuvo) {
        this.menuMapper.insertSelective(menuvo);
    }

    @Override
    public void updateMenu(Menuvo menuvo) {
        this.menuMapper.updateByPrimaryKeySelective(menuvo);
    }

    @Override
    public void deleteMenu(Menuvo menuvo) {
        //删除菜单表的数据
        this.menuMapper.deleteByPrimaryKey(menuvo.getId());
        //根据菜单id删除sys_role_menu里面的数据
        this.menuMapper.deleteRoleMenuByMid(menuvo.getId());
    }

    @Override
    public Integer queryMenuByPid(Integer pid) {
        return this.menuMapper.queryMenuByPid(pid);
    }

}
