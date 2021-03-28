package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.mapper.StudentMapper;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 管理员查询所有学生信息
     *
     * @return Student对象
     */
    @Override
    public List<Student> selectAllStu() {
        return this.studentMapper.selectAllStu();
    }

    /**
     * 教师查看名下学生信息
     *
     * @param cno 教师工号
     * @return Student对象
     */
    @Override
    public List<Student> teacherSelectStu(String cno) {
        return this.studentMapper.teacherSelectStu(cno);
    }

    /**
     * 根据学生学号查看单个信息
     *
     * @param sno 学生学号
     * @return Student对象
     */
    @Override
    public Student studentSelectStu(String sno) {
        return this.studentMapper.studentSelectStu(sno);
    }

    /**
     * 登录查询
     *
     * @param student
     * @return
     */
    @Override
    public Student loginSelect(Student student) {
        return this.studentMapper.loginSelect(student);
    }

    /**
     * 插入单个学生信息
     *
     * @param stu 学生信息
     * @return int数值
     */
    @Override
    public Integer InsertStu(Student stu) {
        return this.studentMapper.InsertStu(stu);
    }

    /**
     * 修改学生信息
     *
     * @param stu 学生信息
     * @return int数值
     */
    @Override
    public Integer UpdateStu(Student stu) {
        return this.studentMapper.UpdateStu(stu);
    }

    /**
     * 删除学生信息
     *
     * @param id 学生id
     * @return
     */
    @Override
    public Integer deleteStu(Integer id) {
        return this.studentMapper.deleteStu(id);
    }
}
