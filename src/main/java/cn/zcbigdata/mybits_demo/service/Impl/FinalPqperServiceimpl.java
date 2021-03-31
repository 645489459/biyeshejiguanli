package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.FinalPaper;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;
import cn.zcbigdata.mybits_demo.mapper.FinalPaperMapper;
import cn.zcbigdata.mybits_demo.service.FinalPqperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinalPqperServiceimpl implements FinalPqperService {
    @Resource
    private FinalPaperMapper finalPaperMapper;

    /**
     * 教师查看最终论文情况
     *
     * @param cno
     * @return OpeningReportVo类型
     */
    @Override
    public List<ReportPaperVo> selectFinPapList(String cno) {
        return this.finalPaperMapper.selectFinPapList(cno);
    }

    /**
     * 学生查看最终论文情况
     *
     * @param sno
     * @return OpeningReportVo类型
     */
    @Override
    public ReportPaperVo selectFinPap(String sno) {
        return this.finalPaperMapper.selectFinPap(sno);
    }

    /**
     * 学生添加开题报告内容
     *
     * @param finalPaper
     * @return int类型
     */
    @Override
    public int InsertMidPap(FinalPaper finalPaper) {
        return this.finalPaperMapper.InsertMidPap(finalPaper);
    }

    /**
     * 教师对最终论文进行审核
     *
     * @param finalPaper
     * @return
     */
    @Override
    public int updateFinPap(FinalPaper finalPaper) {
        return this.finalPaperMapper.updateFinPap(finalPaper);
    }
}
