package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherTitle;

import java.util.List;

public interface TeacherTitleService {
    int examStudentTitle(TeacherTitle teacherTitle);

    int selectCount(String cnoString);

    List<TeacherTitle> selectStudentTitle(int pageInteger, int limitInteger, String cnoString);
}
