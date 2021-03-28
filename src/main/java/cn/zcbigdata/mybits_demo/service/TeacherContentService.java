package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherContent;
import cn.zcbigdata.mybits_demo.mapper.TeacherContentMapper;

import java.util.List;

public interface TeacherContentService {

    List<TeacherContent> selectAll(String cnoString);

    int update(TeacherContent teacherContent);
}
