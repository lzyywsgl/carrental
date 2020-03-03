package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.vo.Menuvo;

import java.util.List;

/**
 * 菜单管理服务接口
 */
public interface MenuService {

    /**
     * 查询所有菜单返回
     *
     * @return List<Menu>
     */
    public List<Menu> queryAllMenuForList(Menuvo menuvo);

    /**
     * 根据用户id查询用户的可用菜单
     *
     * @return List<Menu>
     */
    public List<Menu> queryMenuByUserIdForList(Menuvo menuvo, Integer userId);
}
