package com.lzywsgl.sys.service;

import com.lzywsgl.sys.domain.News;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Newsvo;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName NewsService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/9 22:23
 * @Version 1.0
 **/
public interface NewsService {
    /**
     * 查询所有公告
     */
    DataGridView queryAllNews(Newsvo newsvo);

    /**
     * 添加公告
     */
    void addNews(Newsvo newsvo);

    /**
     * 修改公告
     */
    void updateNews(Newsvo newsvo);

    /**
     * 根据id删除公告
     */
    void deleteNews(Integer newsid);

    /**
     * 批量删除公告
     */
    void deleteBatchNews(Integer[] ids);

    /**
     * 查询一个公告
     */
    News queryNewsById(Integer id);

}
