package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherOpen;

import java.util.List;

public interface TeacherOpenService {
    int update(TeacherOpen teacherOpen);

    List<TeacherOpen> selectAll(int pageInteger, int limitInteger, String cnoString);

    int selectCount(String cnoString);
}
