package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.AdminContent;
import cn.zcbigdata.mybits_demo.mapper.AdminContentMapper;
import cn.zcbigdata.mybits_demo.service.AdminContentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminContentServiceImpl implements AdminContentService {
    @Autowired
    private AdminContentMapper adminContentMapper;
    @Override
    public List<AdminContent> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.adminContentMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(AdminContent adminContent) {
        return this.adminContentMapper.insert(adminContent);
    }
}
