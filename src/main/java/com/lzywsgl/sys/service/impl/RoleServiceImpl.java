package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.domain.Role;
import com.lzywsgl.sys.mapper.MenuMapper;
import com.lzywsgl.sys.mapper.RoleMapper;
import com.lzywsgl.sys.service.RoleService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.TreeNode;
import com.lzywsgl.sys.vo.Rolevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private final MenuMapper menuMapper;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper, MenuMapper menuMapper) {
        this.roleMapper = roleMapper;
        this.menuMapper = menuMapper;
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

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        // 查询所有的可用菜单
        Menu menu = new Menu();
        menu.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Menu> allMenu = menuMapper.queryAllMenu(menu);
        // 根据角色id查询当前角色拥有的菜单
        List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE, roleid);
        List<TreeNode> data = new ArrayList<>();
        for (Menu menu1 : allMenu) {
            String checkArr = SysConstast.CODE_ZERO + "";
            for (Menu menu2 : roleMenu) {
                if (menu1.getId().equals(menu2.getId())) {
                    checkArr = SysConstast.CODE_ONE + "";
                    break;
                }
            }
            Integer id = menu1.getId();
            Integer pid = menu1.getPid();
            String title = menu1.getTitle();
            Boolean spread = menu1.getSpread().equals(SysConstast.SPREAD_TURE);
            data.add(new TreeNode(id, pid, title, spread, checkArr));
        }
        return new DataGridView(data);
    }

    @Override
    public void saveRoleMenu(Rolevo rolevo) {
        Integer rid = rolevo.getRoleid();
        Integer[] mids = rolevo.getIds();
        //根据rid删除sys_role_menu里面所有数据
        this.roleMapper.deleteRoleMenuByRid(rid);
        //保存角色和菜单的关系
        for (Integer mid : mids) {
            this.roleMapper.insertRoleMenu(rid,mid);
        }
    }
}
