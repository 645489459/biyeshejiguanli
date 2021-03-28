package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherFinal;
import cn.zcbigdata.mybits_demo.mapper.TeacherFinalMapper;
import cn.zcbigdata.mybits_demo.service.TeacherFinalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherFinalServiceImpl implements TeacherFinalService {

    @Autowired
    private TeacherFinalMapper teacherFinalMapper;
    @Override
    public int update(TeacherFinal teacherFinal) {
        return this.teacherFinalMapper.update(teacherFinal);
    }

    @Override
    public List<TeacherFinal> selectAll(int pageInteger, int limitInteger, String cnoString) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.teacherFinalMapper.selectAll(pageIndex,pageSize,cnoString);
    }

    @Override
    public int selectCount(String cnoString) {
        return this.teacherFinalMapper.selectCount(cnoString);
    }
}
