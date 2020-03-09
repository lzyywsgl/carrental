package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.service.UserService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import com.lzywsgl.sys.vo.Uservo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/8 23:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 加载用户列表返回DataGridView
     */
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(Uservo uservo) {
        return this.userService.queryAllUser(uservo);
    }

    /**
     * 添加用户
     */
    @RequestMapping("addUser")
    public ResultObj addUser(Uservo uservo) {
        try {
            this.userService.addUser(uservo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改用户
     */
    @RequestMapping("updateUser")
    public ResultObj upadteuser(Uservo uservo) {
        try {
            this.userService.updateUser(uservo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除用户
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteuser(Uservo uservo) {
        try {
            this.userService.deleteUser(uservo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除用户
     */
    @RequestMapping("deleteBatchUser")
    public ResultObj deleteBatchUser(Uservo uservo) {
        try {
            this.userService.deleteBatchUser(uservo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置用户密码
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(Uservo uservo) {
        try {
            this.userService.resetUserPwd(uservo.getUserid());
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }
}
