package com.lzywsgl.sys.service;

import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.LogInfovo;

public interface LogInfoService {
    /**
     * 查询所有日志
     */
    public DataGridView queryAllLogInfo(LogInfovo logInfovo);

    /**
     * 添加日志
     */
    public void addLogInfo(LogInfovo logInfovo);

    /**
     * 根据id删除日志
     */
    public void deleteLogInfo(Integer logInfoid);

    /**
     * 批量删除日志
     */
    public void deletebatchLogInfo(Integer[] ids);
}
