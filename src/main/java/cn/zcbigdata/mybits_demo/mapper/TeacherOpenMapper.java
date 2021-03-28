package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherOpen;

import java.util.List;

public interface TeacherOpenMapper {

    int update(TeacherOpen teacherOpen);

    List<TeacherOpen> selectAll(int pageIndex, int pageSize, String cnoString);

    int selectCount(String cnoString);
}
