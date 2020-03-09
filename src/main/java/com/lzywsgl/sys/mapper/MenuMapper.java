package com.lzywsgl.sys.mapper;

import com.lzywsgl.sys.domain.Menu;
import org.apache.ibatis.annotations.Param;

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
     */
    List<Menu> queryAllMenu(Menu menu);

    /**
     * 根据pid查询菜单数量
     */
    Integer queryMenuByPid(@Param("pid") Integer pid);

    /**
     * 根据菜单id删除sys_role_menu里面的数据
     */
    void deleteRoleMenuByMid(@Param("mid") Integer mid);

    /**
     * 根据角色ID查询菜单
     */
    List<Menu> queryMenuByRoleId(@Param("available") Integer available, @Param("rid") Integer rid);

    /**
     * 保存用户和角色的关系
     */
    List<Menu> queryMenuByUid(@Param("available") Integer available, @Param("uid") Integer userId);


}