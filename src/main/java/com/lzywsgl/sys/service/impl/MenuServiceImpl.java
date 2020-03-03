package com.lzywsgl.sys.service.impl;

import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.mapper.MenuMapper;
import com.lzywsgl.sys.service.MenuService;
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
}
