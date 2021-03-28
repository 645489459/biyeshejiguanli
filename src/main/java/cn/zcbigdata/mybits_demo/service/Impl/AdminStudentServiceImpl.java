package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.AdminStudent;
import cn.zcbigdata.mybits_demo.mapper.AdminStudentMapper;
import cn.zcbigdata.mybits_demo.service.AdminStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminStudentServiceImpl  implements AdminStudentService {

    @Autowired
    private AdminStudentMapper adminStudentMapper;

    @Override
    public List<AdminStudent> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.adminStudentMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(AdminStudent adminStudent) {
        return this.adminStudentMapper.insert(adminStudent);
    }

    @Override
    public int delete(int id) {
        return this.adminStudentMapper.delete(id);
    }

    @Override
    public int update(AdminStudent adminStudent) {
        return this.adminStudentMapper.update(adminStudent);
    }

    @Override
    public int selectCount() {
        return this.adminStudentMapper.selectCount();
    }

    @Override
    public AdminStudent login(String sno, String password) {
        return this.adminStudentMapper.login(sno,password);
    }

    @Override
    public int regist(AdminStudent adminStudent) {
        return this.adminStudentMapper.regist(adminStudent);
    }
}
