package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.AdminTeacher;

import java.util.List;

public interface AdminTeacherService {
    List<AdminTeacher> selectAll(int pageInteger, int limitInteger);

    int insert(AdminTeacher adminTeacher);

    int delete(int id);

    int update(AdminTeacher adminTeacher);

    int selectCount();

    AdminTeacher login(String cno,String password);
}
