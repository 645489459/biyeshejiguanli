package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherContent;

import java.util.List;

public interface TeacherContentMapper {

    List<TeacherContent> selectAll(String cnoString);

    int update(TeacherContent teacherContent);
}
