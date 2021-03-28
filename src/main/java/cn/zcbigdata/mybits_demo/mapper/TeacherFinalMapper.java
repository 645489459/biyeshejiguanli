package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherFinal;
import cn.zcbigdata.mybits_demo.entity.TeacherMiddle;

import java.util.List;

public interface TeacherFinalMapper {

    int update(TeacherFinal teacherFinal);

    List<TeacherFinal> selectAll(int pageIndex, int pageSize, String cnoString);

    int selectCount(String cnoString);
}
