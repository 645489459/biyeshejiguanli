package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.TeacherContent;
import cn.zcbigdata.mybits_demo.mapper.TeacherContentMapper;
import cn.zcbigdata.mybits_demo.service.TeacherContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherContentServiceimpl implements TeacherContentService {
    @Resource
    private TeacherContentMapper teacherContentMapper;

    /**
     * 查询教师公告
     *
     * @param cno 教师工号
     * @return TeacherContent类型
     */
    @Override
    public TeacherContent selectTcn(String cno) {
        return this.teacherContentMapper.selectTcn(cno);
    }

    /**
     * 添加教师公告
     *
     * @param teacherContent 公告内容
     * @return int类型
     */
    @Override
    public int insertTcn(TeacherContent teacherContent) {
        return this.teacherContentMapper.insertTcn(teacherContent);
    }
}
