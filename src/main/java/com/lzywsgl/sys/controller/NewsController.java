package com.lzywsgl.sys.controller;

import com.lzywsgl.sys.domain.User;
import com.lzywsgl.sys.service.NewsService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.utils.ResultObj;
import com.lzywsgl.sys.utils.WebUtils;
import com.lzywsgl.sys.vo.Newsvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName NewsController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/9 22:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /**
     * 加载公告列表返回DataGridView
     */
    @RequestMapping("loadAllNews")
    public DataGridView loadAllNews(Newsvo newsvo) {
        return this.newsService.queryAllNews(newsvo);
    }

    /**
     * 添加公告
     */
    @RequestMapping("addNews")
    public ResultObj addNews(Newsvo newsvo) {
        try {
            newsvo.setCreatetime(new Date());
            User user = (User) WebUtils.getHttpSession().getAttribute("user");
            newsvo.setOpername(user.getRealname());
            this.newsService.addNews(newsvo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改公告
     */
    @RequestMapping("updateNews")
    public ResultObj updateNews(Newsvo newsvo) {
        try {
            this.newsService.updateNews(newsvo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除公告
     */
    @RequestMapping("deleteNews")
    public ResultObj deleteNews(Newsvo newsvo) {
        try {
            this.newsService.deleteNews(newsvo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     */
    @RequestMapping("deleteBatchNews")
    public ResultObj deleteBatchNews(Newsvo newsvo) {
        try {
            this.newsService.deleteBatchNews(newsvo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
