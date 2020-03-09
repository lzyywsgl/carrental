package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.domain.Loginfo;
import com.lzywsgl.sys.service.LogInfoService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import com.lzywsgl.sys.vo.LogInfovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName LogInfoController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/9 17:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("logInfo")
public class LogInfoController {
    private final LogInfoService logInfoService;

    @Autowired
    public LogInfoController(LogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    /**
     * 加载日志列表返回DataGridView
     */
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfovo logInfovo) {
        return this.logInfoService.queryAllLogInfo(logInfovo);
    }

    /**
     * 删除日志
     */
    @RequestMapping("deleteLogInfo")
    public ResultObj deleteLogInfo(LogInfovo logInfovo) {
        try {
            this.logInfoService.deleteLogInfo(logInfovo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志
     */
    @RequestMapping("deleteBatchLogInfo")
    public ResultObj deleteBatchLogInfo(LogInfovo logInfovo) {
        try {
            this.logInfoService.deletebatchLogInfo(logInfovo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
