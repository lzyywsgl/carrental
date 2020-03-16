package com.lzywsgl.sys.task;

import com.lzywsgl.sys.constast.SysConstast;
import com.lzywsgl.sys.utils.AppFileUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

/**
 * @author Administrator
 * @title: RecyleTempFileTask
 * @projectName carrental
 * @description: 定时任务
 * @date 2020/3/16 17:14
 */
@Component
@EnableScheduling
public class RecyleTempFileTask {
    /**
     * 每天晚上12点
     */
    @Scheduled(cron = "0 0 0 * * ? ")
    public void recyleTempFile() {
        File file = new File(AppFileUtils.PATH);
        deleteFile(file);
    }

    /**
     * 删除图片
     */
    public void deleteFile(File file) {
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null & Objects.requireNonNull(files).length > 0) {
                for (File file1 : files) {
                    if (file1.isFile()) {
                        if (file1.getName().endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
                            file1.delete();
                        }
                    } else {
                        // 如果是文件夹递归删除
                        deleteFile(file1);
                    }
                }
            }
        }
    }
}
}
