package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherTitle;

import java.util.List;

public interface TeacherTitleMapper {

    int examStudentTitle(TeacherTitle teacherTitle);

    int selectCount(String cnoString);

    List<TeacherTitle> selectStudentTitle(int pageIndex, int pageSize, String cnoString);
}
