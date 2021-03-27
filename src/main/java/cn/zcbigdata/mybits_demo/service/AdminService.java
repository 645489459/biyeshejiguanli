package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Admin;

import java.util.List;

/**
 * @author admin
 */
public interface AdminService {
    /**
     *  查询所有管理员和教师
     * @return  Admin类型数据
     */
    List<Admin> selectAllAdm();

    /**
     *  添加管理员或教师
     * @param admin
     * @return Integer类型数据
     */
    Integer InsertAdm(Admin admin);

    /**
     * 修改管理员或者教师信息
     * @param admin
     * @return Integer类型数据
     */
    Integer UpdateAdm(Admin admin);

    /**
     * 删除管理员或者教师
     * @param id
     * @return Integer类型数据
     */
    Integer DeleteAdm(Integer id);
}
