package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherMiddle;
import cn.zcbigdata.mybits_demo.entity.TeacherOpen;

import java.util.List;

public interface TeacherMiddleMapper {

    int update(TeacherMiddle teacherMiddle);

    List<TeacherMiddle> selectAll(int pageIndex, int pageSize, String cnoString);

    int selectCount(String cnoString);
}
