package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.utils.AppFileUtils;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @title: FileController
 * @projectName carrental
 * @description: 文件上传下载控制器
 * @date 2020/3/14 16:47
 */
@Controller
@RequestMapping("file")
public class FileController {
    /**
     * 添加
     *
     * @throws IOException           IO操作异常
     * @throws IllegalStateException 非法状态异常
     */
    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
        // 文件上传的父目录
        String parentPath = AppFileUtils.PATH;
        // 得到当前日期作为文件加名称
        String dirName = RandomUtils.getCurrentDateForString();
        // 构造文件夹对象
        File file = new File(parentPath, dirName);
        if (!file.exists()) {
            file.mkdirs(); // 创建文件夹
        }
        // 得到文件原名
        String oldName = multipartFile.getOriginalFilename();
        String newName = RandomUtils.createFileNameUseTime(oldName, SysConstast.FILE_UPLOAD_TEMP);
        File dest = new File(file, newName);
        multipartFile.transferTo(dest);
        Map<String, Object> map = new HashMap<>();
        map.put("src", dirName + "/" + newName);
        return new DataGridView(map);
    }

    /**
     * 不下载只显示
     */
    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response) {
        return AppFileUtils.downloadFile(response, path," ");
    }

    /**
     * 下载图片
     */
    @RequestMapping("downloadFile")
    public ResponseEntity<Object> downloadFile(String path, HttpServletResponse response) {
        String oldName = "";
        return AppFileUtils.downloadFile(response, path, oldName);
    }
}
