package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherOpen;
import cn.zcbigdata.mybits_demo.mapper.TeacherOpenMapper;
import cn.zcbigdata.mybits_demo.service.TeacherOpenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherOpenServiceImpl implements TeacherOpenService {

    @Autowired
    private TeacherOpenMapper teacherOpenMapper;

    @Override
    public int update(TeacherOpen teacherOpen) {
        return this.teacherOpenMapper.update(teacherOpen);
    }

    @Override
    public List<TeacherOpen> selectAll(int pageInteger, int limitInteger, String cnoString) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherOpenMapper.selectAll(pageIndex,pageSize,cnoString);
    }

    @Override
    public int selectCount(String cnoString) {
        return this.teacherOpenMapper.selectCount(cnoString);
    }
}
