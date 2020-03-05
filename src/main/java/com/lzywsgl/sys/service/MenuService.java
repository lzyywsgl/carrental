package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Menuvo;

import java.util.List;

/**
 * 菜单管理服务接口
 */
public interface MenuService {

    /**
     * 查询所有菜单返回
     * @return List<Menu>
     */
    List<Menu> queryAllMenuForList(Menuvo menuvo);

    /**
     * 根据用户id查询用户的可用菜单
     *
     * @return List<Menu>
     */
    List<Menu> queryMenuByUserIdForList(Menuvo menuvo, Integer userId);

    /**
     * 查询所有菜单
     *
     * @return DataGridView
     */
    DataGridView queryAllMenu(Menuvo menuvo);

    /**
     * 添加菜单
     */
    void addMenu(Menuvo menuvo);

    /**
     * 修改菜单
     */
    void updateMenu(Menuvo menuvo);

    /**
     * 根据id删除菜单
     */
    void deleteMenu(Menuvo menuvo);

    /**
     * 根据pid查询菜单数量
     */
    Integer queryMenuByPid(Integer pid);
}
