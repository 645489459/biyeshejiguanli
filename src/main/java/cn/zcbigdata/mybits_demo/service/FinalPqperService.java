package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.FinalPaper;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;

import java.util.List;

public interface FinalPqperService {
    /**
     * 教师查看最终论文情况
     * @param cno
     * @return OpeningReportVo类型
     */
    List<ReportPaperVo> selectFinPapList(String cno);

    /**
     * 学生添加开题报告内容
     * @param finalPaper
     * @return int类型
     */
    int InsertMidPap(FinalPaper finalPaper);

    /**
     * 教师对最终论文进行审核
     * @param finalPaper
     * @return
     */
    int updateFinPap(FinalPaper finalPaper);
}
