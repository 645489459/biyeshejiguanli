package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.AdminStudent;

import java.util.List;

public interface AdminStudentMapper {
    List<AdminStudent> selectAll(int pageIndex, int pageSize);

    int insert(AdminStudent adminStudent);

    int delete(int id);

    int update(AdminStudent adminStudent);

    int selectCount();

    AdminStudent login(String sno,String password);

    int regist(AdminStudent adminStudent);
}
