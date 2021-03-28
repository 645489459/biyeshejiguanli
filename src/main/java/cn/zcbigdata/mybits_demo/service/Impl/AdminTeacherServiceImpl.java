package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.AdminTeacher;
import cn.zcbigdata.mybits_demo.mapper.AdminStudentMapper;
import cn.zcbigdata.mybits_demo.mapper.AdminTeacherMapper;
import cn.zcbigdata.mybits_demo.service.AdminTeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminTeacherServiceImpl implements AdminTeacherService {

    @Autowired
    private AdminTeacherMapper adminTeacherMapper;

    @Override
    public List<AdminTeacher> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.adminTeacherMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(AdminTeacher adminTeacher) {
        return this.adminTeacherMapper.insert(adminTeacher);
    }

    @Override
    public int delete(int id) {
        return this.adminTeacherMapper.delete(id);
    }

    @Override
    public int update(AdminTeacher adminTeacher) {
        return this.adminTeacherMapper.update(adminTeacher);
    }

    @Override
    public int selectCount() {
        return this.adminTeacherMapper.selectCount();
    }

    @Override
    public AdminTeacher login(String cno, String password) {
        return this.adminTeacherMapper.login(cno,password);
    }
}
