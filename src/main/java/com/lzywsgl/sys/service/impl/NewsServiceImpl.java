package com.lzywsgl.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzywsgl.sys.domain.News;
import com.lzywsgl.sys.mapper.NewsMapper;
import com.lzywsgl.sys.service.NewsService;
import com.lzywsgl.sys.utils.DataGridView;
import com.lzywsgl.sys.vo.Newsvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName NewsServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/9 22:28
 * @Version 1.0
 **/
@Service
public class NewsServiceImpl implements NewsService {
    private final NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public DataGridView queryAllNews(Newsvo newsvo) {
        Page<Object> page = PageHelper.startPage(newsvo.getPage(), newsvo.getLimit());
        List<News> data = this.newsMapper.queryAllNews(newsvo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addNews(Newsvo newsvo) {
        this.newsMapper.insertSelective(newsvo);
    }

    @Override
    public void updateNews(Newsvo newsvo) {
        this.newsMapper.updateByPrimaryKeySelective(newsvo);
    }

    @Override
    public void deleteNews(Integer newsid) {
        this.newsMapper.deleteByPrimaryKey(newsid);
    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer integer : ids) {
            this.newsMapper.deleteByPrimaryKey(integer);
        }
    }
}
