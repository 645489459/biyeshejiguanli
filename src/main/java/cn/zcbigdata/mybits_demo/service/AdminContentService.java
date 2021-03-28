package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.AdminContent;
import cn.zcbigdata.mybits_demo.mapper.AdminContentMapper;

import java.util.List;

public interface AdminContentService {
    List<AdminContent> selectAll(int pageInteger, int limitInteger);

    int insert(AdminContent adminContent);
}
