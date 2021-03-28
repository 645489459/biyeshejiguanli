package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherContent;
import cn.zcbigdata.mybits_demo.mapper.TeacherContentMapper;
import cn.zcbigdata.mybits_demo.service.TeacherContentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherContentServiceImpl implements TeacherContentService {

    @Autowired
    private  TeacherContentMapper teacherContentMapper;

    @Override
    public List<TeacherContent> selectAll(String cnoString) {
        return this.teacherContentMapper.selectAll(cnoString);
    }

    @Override
    public int update(TeacherContent teacherContent) {
        return this.teacherContentMapper.update(teacherContent);
    }
}
