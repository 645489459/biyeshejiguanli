package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.OpeningReport;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;

import java.util.List;

/**开题报告表
 * @author admin
 */
public interface OpeningReportMapper {
    /**
     * 教师查看开题报告情况
     * @param cno
     * @return OpeningReportVo类型
     */
    List<ReportPaperVo>selectOpeRepList(String cno);

    /**
     * 学生添加开题报告内容
     * @param openingReport
     * @return int类型
     */
    int InsertOpeRep(OpeningReport openingReport);

    /**
     * 教师对开题报告进行审核
     * @param openingReport
     * @return
     */
    int updateOpeRep(OpeningReport openingReport);

    /**
     * 学生查询开题报告
     * @param reportPaperVo
     * @return
     */
    ReportPaperVo selectOpeRep(String sno);
}
