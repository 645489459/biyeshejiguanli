package cn.zcbigdata.mybits_demo.mapper;


import cn.zcbigdata.mybits_demo.entity.AdminTeacher;

import java.util.List;

public interface AdminTeacherMapper {
    List<AdminTeacher> selectAll(int pageIndex, int pageSize);

    int insert(AdminTeacher adminTeacher);

    int delete(int id);

    int update(AdminTeacher adminTeacher);

    int selectCount();

    AdminTeacher login(String cno,String password);

}

