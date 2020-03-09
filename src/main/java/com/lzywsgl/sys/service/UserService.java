package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Uservo;

public interface UserService {
    /**
     * 用户服务接口
     */
    User login(Uservo uservo);

    /**
     * 查询所有用户
     */

    public DataGridView queryAllUser(Uservo uservo);

    /**
     * 添加用户
     */
    public void addUser(Uservo uservo);

    /**
     * 修改用户
     */
    public void updateUser(Uservo uservo);

    /**
     * 根据id删除用户
     */
    public void deleteUser(Integer userid);

    /**
     * 批量删除用户
     */
    public void deleteBatchUser(Integer[] ids);

    /**
     * 重置密码
     */
    public void resetUserPwd(Integer userid);
}
