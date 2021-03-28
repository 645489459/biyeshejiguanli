package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.AdminStudent;

import java.util.List;

public interface AdminStudentService {
    List<AdminStudent> selectAll(int pageInteger, int limitInteger);

    int insert(AdminStudent adminStudent);

    int delete(int id);

    int update(AdminStudent adminStudent);

    int selectCount();

    AdminStudent login(String sno,String password);

    int regist(AdminStudent adminStudent);
}
