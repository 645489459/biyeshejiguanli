package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherMiddle;
import cn.zcbigdata.mybits_demo.entity.TeacherOpen;
import cn.zcbigdata.mybits_demo.mapper.TeacherMiddleMapper;
import cn.zcbigdata.mybits_demo.mapper.TeacherOpenMapper;
import cn.zcbigdata.mybits_demo.service.TeacherMiddleService;
import cn.zcbigdata.mybits_demo.service.TeacherOpenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherMiddleServiceImpl implements TeacherMiddleService {

    @Autowired
    private TeacherMiddleMapper teacherMiddleMapper;


    @Override
    public int update(TeacherMiddle teacherMiddle) {
        return this.teacherMiddleMapper.update(teacherMiddle);
    }

    @Override
    public List<TeacherMiddle> selectAll(int pageInteger, int limitInteger, String cnoString) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherMiddleMapper.selectAll(pageIndex,pageSize,cnoString);
    }

    @Override
    public int selectCount(String cnoString) {
        return this.teacherMiddleMapper.selectCount(cnoString);
    }
}
