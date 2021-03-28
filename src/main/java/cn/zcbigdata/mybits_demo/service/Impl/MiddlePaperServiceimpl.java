package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.MiddlePaper;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;
import cn.zcbigdata.mybits_demo.mapper.MiddlePaperMapper;
import cn.zcbigdata.mybits_demo.service.MiddlePaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiddlePaperServiceimpl implements MiddlePaperService {
    @Resource
    private MiddlePaperMapper middlePaperMapper;

    /**
     * 教师查看中期论文情况
     *
     * @param cno
     * @return OpeningReportVo类型
     */
    @Override
    public List<ReportPaperVo> selectMidPapList(String cno) {
        return this.middlePaperMapper.selectMidPapList(cno);
    }

    /**
     * 学生添加开题报告内容
     *
     * @param middlePaper
     * @return int类型
     */
    @Override
    public int InsertMidPap(MiddlePaper middlePaper) {
        return this.middlePaperMapper.InsertMidPap(middlePaper);
    }

    /**
     * 教师对中期论文进行审核
     *
     * @param middlePaper
     * @return
     */
    @Override
    public int updateMidPap(MiddlePaper middlePaper) {
        return this.middlePaperMapper.updateMidPap(middlePaper);
    }
}
