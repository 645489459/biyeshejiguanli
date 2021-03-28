package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.MiddlePaper;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;

import java.util.List;

/**中期论文表
 * @author admin
 */
public interface MiddlePaperMapper {
    /**
     * 教师查看中期论文情况
     * @param cno
     * @return OpeningReportVo类型
     */
    List<ReportPaperVo>selectMidPapList(String cno);

    /**
     * 学生添加开题报告内容
     * @param middlePaper
     * @return int类型
     */
    int InsertMidPap(MiddlePaper middlePaper);

    /**
     * 教师对中期论文进行审核
     * @param middlePaper
     * @return
     */
    int updateMidPap(MiddlePaper middlePaper);
}
