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
    public List<Role> queryAllRoleForList(Rolevo rolevo);

    /**
     * 根据用户id查询用户的可用角色
     */
    public List<Role> queryRoleByUserIdForList(Rolevo rolevo, Integer userId);

    /**
     * 查询所有角色
     */
    public DataGridView queryAllRole(Rolevo rolevo);

    /**
     * 添加角色
     */
    public void addRole(Rolevo rolevo);

    /**
     * 修改角色
     */
    public void updateRole(Rolevo rolevo);

    /**
     * 根据id删除角色
     */
    public void deleteRole(Integer roleid);
    /**
     * 批量删除角色
     */
    public void deleteBatchRole(Integer [] ids);
}
