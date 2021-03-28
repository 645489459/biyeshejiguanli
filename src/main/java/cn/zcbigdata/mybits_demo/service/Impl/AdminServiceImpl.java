package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Admin;
import cn.zcbigdata.mybits_demo.mapper.AdminMapper;
import cn.zcbigdata.mybits_demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    /**
     * 查询所有管理员和教师
     *
     * @return Admin类型数据
     */
    @Override
    public List<Admin> selectAllAdm() {
        return this.adminMapper.selectAllAdm();
    }

    /**
     * 用于登陆查询
     *
     * @return Admin类型
     */
    @Override
    public Admin adminLogin(Admin admin) {
        return this.adminMapper.adminLogin(admin);
    }

    /**
     * 添加管理员或教师
     *
     * @param admin
     * @return Integer类型数据
     */
    @Override
    public Integer InsertAdm(Admin admin) {
        return this.adminMapper.InsertAdm(admin);
    }

    /**
     * 修改管理员或者教师信息
     *
     * @param admin
     * @return Integer类型数据
     */
    @Override
    public Integer UpdateAdm(Admin admin) {
        return this.adminMapper.UpdateAdm(admin);
    }

    /**
     * 删除管理员或者教师
     *
     * @param id
     * @return Integer类型数据
     */
    @Override
    public Integer DeleteAdm(Integer id) {
        return this.adminMapper.DeleteAdm(id);
    }
}
