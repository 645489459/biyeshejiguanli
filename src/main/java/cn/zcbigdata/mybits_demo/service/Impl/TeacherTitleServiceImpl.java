package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherTitle;
import cn.zcbigdata.mybits_demo.mapper.TeacherTitleMapper;
import cn.zcbigdata.mybits_demo.service.TeacherTitleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherTitleServiceImpl implements TeacherTitleService {

    @Autowired
    private TeacherTitleMapper teacherTitleMapper;

    @Override
    public int examStudentTitle(TeacherTitle teacherTitle) {
        return this.teacherTitleMapper.examStudentTitle(teacherTitle);
    }

    @Override
    public int selectCount(String cnoString) {
        return this.teacherTitleMapper.selectCount(cnoString);
    }

    @Override
    public List<TeacherTitle> selectStudentTitle(int pageInteger, int limitInteger, String cnoString) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherTitleMapper.selectStudentTitle(pageIndex,pageSize,cnoString);
    }
}
