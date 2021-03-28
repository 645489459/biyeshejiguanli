package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.AdminContent;

import java.util.List;

public interface AdminContentMapper {

    List<AdminContent> selectAll(int pageIndex, int pageSize);

    int insert(AdminContent adminContent);
}
