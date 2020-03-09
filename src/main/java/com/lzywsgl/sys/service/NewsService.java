package com.lzywsgl.sys.service;

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
    public DataGridView queryAllNews(Newsvo newsvo);

    /**
     * 添加公告
     */
    public void addNews(Newsvo newsvo);

    /**
     * 修改公告
     */
    public void updateNews(Newsvo newsvo);

    /**
     * 根据id删除公告
     */
    public void deleteNews(Integer newsid);

    /**
     * 批量删除公告
     */
    public void deleteBatchNews(Integer[] ids);
}
