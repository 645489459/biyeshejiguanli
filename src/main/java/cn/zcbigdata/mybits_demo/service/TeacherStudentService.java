package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherStudent;

import java.util.List;

public interface TeacherStudentService {

    int insert(TeacherStudent teacherStudent);

    List<TeacherStudent> selectAll(int pageInteger, int limitInteger, String cnoString);

    int selectCount(String cnoString);
}
