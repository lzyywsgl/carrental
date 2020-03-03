package com.lzywsgl.sys.mapper;

import com.lzywsgl.sys.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登陆
     *
     * @param user 用户
     * @return 登录
     */
    User login(User user);
}