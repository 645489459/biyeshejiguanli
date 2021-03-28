package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherStudent;

import java.util.List;

public interface TeacherStudentMapper {
    int insert(TeacherStudent teacherStudent);

    List<TeacherStudent> selectAll(int pageIndex, int pageSize, String cnoString);

    int selectCount(String cnoString);
}
