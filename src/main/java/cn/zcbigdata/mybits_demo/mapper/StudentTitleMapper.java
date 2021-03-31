package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.StudentTitle;
import cn.zcbigdata.mybits_demo.entity.StudentTitleVo;

import java.util.List;

public interface StudentTitleMapper {
    /**
     * 教师查询名下所有学生的选题情况
     * @param cno 教师工号
     * @return StudentTitleVo类型
     */
    List<StudentTitleVo> selectStuTitList(String cno);

    /**
     * 学生查询自己的选题情况
     * @param sno
     * @return
     */
    StudentTitleVo selectStuTit(String sno);
    /**
     *  教师评判选题是否通过
     * @param studentTitle
     * @return int 对象
     */
    int updateStuTit(StudentTitle studentTitle);

    /**
     * 学生添加学生选题
     * @param studentTitle
     * @return int对象
     */
    int InsertStuTit(StudentTitle studentTitle);

    /**
     * 学生修改选题内容
     * @param studentTitle
     * @return int对象
     */
    int updateTit(StudentTitle studentTitle);

}
