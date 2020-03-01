package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.vo.Uservo;

public interface UserService {
    /**
     * 用户服务接口
     */
    User login(Uservo uservo);
}
