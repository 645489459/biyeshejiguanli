package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.StudentTitle;
import cn.zcbigdata.mybits_demo.entity.StudentTitleVo;
import cn.zcbigdata.mybits_demo.mapper.StudentTitleMapper;
import cn.zcbigdata.mybits_demo.service.StudentTitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentTitleServiceimpl implements StudentTitleService {
    @Resource
    private StudentTitleMapper studentTitleMapper;

    /**
     * 教师查询名下所有学生的选题情况
     *
     * @param cno 教师工号
     * @return StudentTitleVo类型
     */
    @Override
    public List<StudentTitleVo> selectStuTitList(String cno) {
        return this.studentTitleMapper.selectStuTitList(cno);
    }

    /**
     * 教师评判选题是否通过
     *
     * @param studentTitle
     * @return int 对象
     */
    @Override
    public int updateStuTit(StudentTitle studentTitle) {
        return this.studentTitleMapper.updateStuTit(studentTitle);
    }

    /**
     * 学生添加学生选题
     *
     * @param studentTitle
     * @return int对象
     */
    @Override
    public int InsertStuTit(StudentTitle studentTitle) {
        return this.studentTitleMapper.InsertStuTit(studentTitle);
    }
}
