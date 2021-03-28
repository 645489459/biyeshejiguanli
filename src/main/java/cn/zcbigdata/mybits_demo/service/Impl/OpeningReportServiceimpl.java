package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.OpeningReport;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;
import cn.zcbigdata.mybits_demo.mapper.OpeningReportMapper;
import cn.zcbigdata.mybits_demo.service.OpeningReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpeningReportServiceimpl implements OpeningReportService {
    @Resource
    private OpeningReportMapper openingReportMapper;

    /**
     * 教师查看开题报告情况
     *
     * @param cno
     * @return OpeningReportVo类型
     */
    @Override
    public List<ReportPaperVo> selectOpeRepList(String cno) {
        return this.openingReportMapper.selectOpeRepList(cno);
    }

    /**
     * 学生添加开题报告内容
     *
     * @param openingReport
     * @return int类型
     */
    @Override
    public int InsertOpeRep(OpeningReport openingReport) {
        return this.openingReportMapper.InsertOpeRep(openingReport);
    }

    /**
     * 教师对开题报告进行审核
     *
     * @param openingReport
     * @return
     */
    @Override
    public int updateOpeRep(OpeningReport openingReport) {
        return this.openingReportMapper.updateOpeRep(openingReport);
    }
}
