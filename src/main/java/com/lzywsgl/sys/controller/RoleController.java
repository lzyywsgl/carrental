package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.service.RoleService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import com.lzywsgl.sys.vo.Rolevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName RoleController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/6 23:09
 * @Version 1.0
 **/
@RestController
@RequestMapping("role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 加载角色列表返回DataGridView
     */
    @RequestMapping("loadAllRole")
    public DataGridView loadAllRole(Rolevo rolevo) {
        return this.roleService.queryAllRole(rolevo);
    }

    /**
     * 添加角色
     */
    @RequestMapping("addRole")
    public ResultObj addRole(Rolevo rolevo) {
        try {
            this.roleService.addRole(rolevo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改角色
     */
    @RequestMapping("updateRole")
    public ResultObj updateRoleResultObj(Rolevo rolevo) {
        try {
            this.roleService.updateRole(rolevo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除角色
     */
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(Rolevo rolevo) {
        try {
            this.roleService.deleteRole(rolevo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除角色
     */
    @RequestMapping("deleteBatchRole")
    public ResultObj deleteBatchRole(Rolevo rolevo) {
        try {
            this.roleService.deleteBatchRole(rolevo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 加载角色管理分配菜单的json
     */
    @RequestMapping("initRoleMenuTreeJson")
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        return this.roleService.initRoleMenuTreeJson(roleid);
    }

    /**
     * 保存角色和菜单的关系
     */
    @RequestMapping("saveRoleMenu")
    public ResultObj saveRoleMenu(Rolevo rolevo) {
        try {
            this.roleService.saveRoleMenu(rolevo);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}
