package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.TeacherContent;

/**教师公告Mapper层
 * @author admin
 */
public interface TeacherContentMapper {
    /**
     * 查询教师公告
     * @param cno 教师工号
     * @return TeacherContent类型
     */
    TeacherContent selectTcn(String cno);

    /**
     * 添加教师公告
     * @param teacherContent 公告内容
     * @return  int类型
     */
    int  insertTcn(TeacherContent teacherContent);
}
