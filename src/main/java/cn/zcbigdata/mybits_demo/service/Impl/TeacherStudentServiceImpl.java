package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherStudent;
import cn.zcbigdata.mybits_demo.mapper.TeacherStudentMapper;
import cn.zcbigdata.mybits_demo.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherStudentServiceImpl implements TeacherStudentService {

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    @Override
    public int insert(TeacherStudent teacherStudent) {
        return this.teacherStudentMapper.insert(teacherStudent);
    }

    //pageInteger：第几页；limitInteger：一页多少个数据
    @Override
    public List<TeacherStudent> selectAll(int pageInteger, int limitInteger, String cnoString) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherStudentMapper.selectAll(pageIndex,pageSize,cnoString);
    }

    @Override
    public int selectCount(String cnoString) {
        return this.teacherStudentMapper.selectCount(cnoString);
    }
}
