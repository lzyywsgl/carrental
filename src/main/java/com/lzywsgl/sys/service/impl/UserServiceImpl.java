package com.lzywsgl.sys.service.impl;

import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.mapper.UserMapper;
import com.lzywsgl.sys.service.UserService;
import com.lzywsgl.sys.vo.Uservo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Uservo uservo) {
        // 密码md5加密
        System.out.println(uservo.getLoginname());
        System.out.println(uservo.getPwd());
        String pwd = DigestUtils.md5DigestAsHex(uservo.getPwd().getBytes());
        uservo.setPwd(pwd);
        return userMapper.login(uservo);
    }
}
