package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.Menu;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.MenuService;
import com.lzywsgl.sys.utils.TreeNode;
import com.lzywsgl.sys.utils.TreeNodeBuilder;
import com.lzywsgl.sys.utils.WebUtils;
import com.lzywsgl.sys.vo.Menuvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
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
        List<Menu> list = null;
        menuvo.setAvailable(SysConstast.AVAILABLE_TRUE);
        if (user.getAvailable() == SysConstast.AVAILABLE_FALSE) {
            list = this.menuService.queryAllMenuForList(menuvo);
        } else {
            list = this.menuService.queryMenuByUserIdForList(menuvo, user.getUserid());
        }
        List<TreeNode> treeNodes = new ArrayList<>();
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
        return TreeNodeBuilder.builder(treeNodes, 1);
    }
}
