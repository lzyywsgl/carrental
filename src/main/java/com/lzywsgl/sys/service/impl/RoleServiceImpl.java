package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.domain.Role;
import com.lzywsgl.sys.mapper.RoleMapper;
import com.lzywsgl.sys.service.RoleService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Rolevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/6 22:50
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> queryAllRoleForList(Rolevo rolevo) {
        return null;
    }

    @Override
    public List<Role> queryRoleByUserIdForList(Rolevo rolevo, Integer userId) {
        return null;
    }

    @Override
    public DataGridView queryAllRole(Rolevo rolevo) {
        Page<Object> page = PageHelper.startPage(rolevo.getPage(), rolevo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(rolevo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addRole(Rolevo rolevo) {
        this.roleMapper.insertSelective(rolevo);
    }

    @Override
    public void updateRole(Rolevo rolevo) {
        this.roleMapper.updateByPrimaryKeySelective(rolevo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        // 删除角色表的数据
        this.roleMapper.deleteByPrimaryKey(roleid);
        // 根据角色id删除sys_role_menu里面的数据
        this.roleMapper.deleteRoleMenuByRid(roleid);
        // 根据角色id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByRid(roleid);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid : ids) {
            deleteRole(rid);
        }
    }
}
