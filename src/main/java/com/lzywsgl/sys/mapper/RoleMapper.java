package com.lzywsgl.sys.mapper;

import com.lzywsgl.sys.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询角色
     */
    List<Role> queryAllRole(Role role);

    /**
     * 根据角色id删除sys_role_menu里面的数据
     */
    void deleteRoleMenuByRid(@Param("roleid") Integer rid);

    /**
     * 根据角色id删除sys_role_user里面的数据
     */
    void deleteRoleUserByRid(@Param("roleid") Integer rid);

    /**
     * 保存角色和菜单的关系sys_role_menu
     */
    void insertRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);
}