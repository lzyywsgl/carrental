package com.lzywsgl.bus.service;

import com.lzywsgl.bus.vo.Checkvo;

import java.util.Map;

/**
 * @author Administrator
 * @title: CheckService
 * @projectName carrental
 * @description: TODO
 * @date 2020/3/17 21:57
 */
public interface CheckService {
    /**
     * 根据出租单号加载检查单的表单数据
     */
    Map<String, Object> initCheckFormData(String rentid);

    /**
     * 保存检查单数据
     */
    void addCheck(Checkvo checkvo);
}
