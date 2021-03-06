package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.MenuService;
import com.lzywsgl.sys.utils.*;
import com.lzywsgl.sys.vo.Menuvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(Menuvo menuvo) {
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        List<Menu> list;
        menuvo.setAvailable(SysConstast.AVAILABLE_TRUE);
        if (user.getType().equals(SysConstast.USER_TYPE_SUPER)) {
            list = this.menuService.queryAllMenuForList(menuvo);
        } else {
            list = this.menuService.queryMenuByUserIdForList(menuvo, user.getUserid());
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        return TreeNodeBuilder.builder(listToNodes(list, treeNodes), 1);
    }

    /**
     * 加载菜单管理右边的菜单树
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(Menuvo menuvo) {
        //只查询可用的
        menuvo.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Menu> list = this.menuService.queryAllMenuForList(menuvo);
        List<TreeNode> treeNodes = new ArrayList<>();
        return new DataGridView(listToNodes(list, treeNodes));
    }

    /**
     * 加载菜单列表返回DataGridView
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(Menuvo menuvo) {
        return this.menuService.queryAllMenu(menuvo);
    }

    /**
     * 添加菜单
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(Menuvo menuvo) {
        try {
            this.menuService.addMenu(menuvo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改菜单
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(Menuvo menuvo) {
        try {
            this.menuService.updateMenu(menuvo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除菜单
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(Menuvo menuvo) {
        try {
            this.menuService.deleteMenu(menuvo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 根据id判断当前菜单有没有子节点
     * 有返回code>=0
     * 没有 返回code<0
     */
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(Menuvo menuvo) {
        //根据pid查询菜单数量
        Integer count = this.menuService.queryMenuByPid(menuvo.getPid());
        if (count > 0) {
            return ResultObj.STATUS_TRUE;
        } else {
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 把list里面的数据放到nodes
     */

    private List<TreeNode> listToNodes(List<Menu> list, List<TreeNode> treeNodes) {
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread().equals(SysConstast.SPREAD_TURE);
            String target = menu.getTarget();
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return treeNodes;
    }
}
