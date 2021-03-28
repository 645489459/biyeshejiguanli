package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.TeacherFinal;
import cn.zcbigdata.mybits_demo.entity.TeacherMiddle;

import java.util.List;

public interface TeacherFinalService {
    int update(TeacherFinal teacherFinal);

    List<TeacherFinal> selectAll(int pageInteger, int limitInteger, String cnoString);

    int selectCount(String cnoString);
}
