package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.mapper.RoleMapper;
import com.lzywsgl.sys.mapper.UserMapper;
import com.lzywsgl.sys.service.UserService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Uservo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RoleMapper roleMapper;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public User login(Uservo uservo) {
        // 密码md5加密
        System.out.println(uservo.getLoginname());
        System.out.println(uservo.getPwd());
        String pwd = DigestUtils.md5DigestAsHex(uservo.getPwd().getBytes());
        uservo.setPwd(pwd);
        return userMapper.login(uservo);
    }

    @Override
    public DataGridView queryAllUser(Uservo uservo) {
        Page<Object> page = PageHelper.startPage(uservo.getPage(), uservo.getLimit());
        List<User> data = this.userMapper.queryAllUser(uservo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addUser(Uservo uservo) {
        //设置默认密码
        uservo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        // 设置用户类型 都是普通用户type=2
        uservo.setType(SysConstast.USER_TYPE_NORMAL);
        this.userMapper.insertSelective(uservo);
    }

    @Override
    public void updateUser(Uservo uservo) {
        this.userMapper.updateByPrimaryKeySelective(uservo);
    }

    @Override
    public void deleteUser(Integer userid) {
        // 删除用户
        this.userMapper.deleteByPrimaryKey(userid);
        // 根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(userid);
    }

    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer uid : ids) {
            this.deleteUser(uid);
        }
    }

    @Override
    public void resetUserPwd(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        // 设置默认密码
        user.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        //更新
        this.userMapper.updateByPrimaryKeySelective(user);
    }
}
