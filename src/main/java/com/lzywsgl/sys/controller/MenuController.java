package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.MenuService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.TreeNode;
import com.lzywsgl.sys.utils.TreeNodeBuilder;
import com.lzywsgl.sys.utils.WebUtils;
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
        List<TreeNode> treeNodes= new ArrayList<>();
        for (Menu menu : list) {
            Integer id=menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
            String href=menu.getHref();
            Boolean spread= menu.getSpread() == SysConstast.SPREAD_TURE;
            String target=menu.getTarget();
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(treeNodes, 1);
    }

    /**
     * 加载菜单管理右边的菜单树
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(Menuvo menuvo) {
        menuvo.setAvailable(SysConstast.AVAILABLE_TRUE); //只查询可用的
        List<Menu> list = this.menuService.queryAllMenuForList(menuvo);
        List<TreeNode> treeNodes= new ArrayList<>();
        listToNodes(list, treeNodes);
        return new DataGridView(treeNodes);
    }

    /**
     *加载菜单列表返回DataGridView
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(Menuvo menuvo) {
        return this.menuService.queryAllMenu(menuvo);
    }
    //把list里面的数据放到nodes
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
