package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.Role;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Rolevo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName RoleService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/6 22:37
 * @Version 1.0
 **/
public interface RoleService {
    /**
     * 查询所有角色返回
     */
    List<Role> queryAllRoleForList(Rolevo rolevo);

    /**
     * 根据用户id查询用户的可用角色
     */
    List<Role> queryRoleByUserIdForList(Rolevo rolevo, Integer userId);

    /**
     * 查询所有角色
     */
    DataGridView queryAllRole(Rolevo rolevo);

    /**
     * 添加角色
     */
    void addRole(Rolevo rolevo);

    /**
     * 修改角色
     */
    void updateRole(Rolevo rolevo);

    /**
     * 根据id删除角色
     */
    void deleteRole(Integer roleid);

    /**
     * 批量删除角色
     */
    void deleteBatchRole(Integer[] ids);

    /**
     * 加载角色管理分配菜单的json
     */
    DataGridView initRoleMenuTreeJson(Integer roleid);

    /**
     * 保存角色和菜单的关系
     */
    void saveRoleMenu(Rolevo rolevo);


}
