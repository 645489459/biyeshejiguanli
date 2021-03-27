package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Student;

import java.util.List;

/**
 * @author admin
 * Student 的 mapper 层
 */
public interface StudentMapper {
    /**
     * 管理员查询所有学生信息
     * @return Student对象
     *
     */
    List<Student> selectAllStu();

    /**
     * 教师查看名下学生信息
     * @param cno 教师工号
     * @return Student对象
     */
    List<Student>teacherSelectStu(String cno);

    /**
     * 根据学生学号查看单个信息
     * @param sno 学生学号
     * @return  Student对象
     */
    Student studentSelectStu(String sno);

    /**
     * 插入单个学生信息
     * @param stu 学生信息
     * @return  int数值
     */
    Integer InsertStu(Student stu);

    /**
     * 修改学生信息
     * @param stu 学生信息
     * @return int数值
     */
    Integer UpdateStu(Student stu);

    /**
     * 删除学生信息
     * @param id 学生id
     * @return
     */
    Integer deleteStu(Integer id);
}
