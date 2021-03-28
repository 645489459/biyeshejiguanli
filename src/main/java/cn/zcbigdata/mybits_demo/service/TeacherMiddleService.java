package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherMiddle;
import cn.zcbigdata.mybits_demo.entity.TeacherOpen;

import java.util.List;

public interface TeacherMiddleService {
    int update(TeacherMiddle teacherMiddle);

    List<TeacherMiddle> selectAll(int pageInteger, int limitInteger, String cnoString);

    int selectCount(String cnoString);
}
