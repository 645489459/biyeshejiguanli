package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.Constants;
import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.OpeningReport;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;
import cn.zcbigdata.mybits_demo.service.OpeningReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/OpeningReport")
public class OpeningReportController {
    @Autowired
    private OpeningReportService openingReportService;
    @GetMapping("/selectOpeRepList")
    public String selectOpeRepList(HttpSession session){
        String flag=session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            String cno=session.getAttribute("cno").toString();
            List<ReportPaperVo> openingReportVos=openingReportService.selectOpeRepList(cno);
            String[] cloums={"ope_title_id","sno","name","cno","cnotent","remark","status"};
            data= ObjtoLayJson.objectToJson(cloums,openingReportVos);
        }
        return data;
    }
    @GetMapping("/updateOpeRep")
    public String updateOpeRep(HttpSession session, @RequestParam Integer id, @RequestParam String status){
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            if (IsNull.checkNull(new Object[]{id, status})) {
                OpeningReport openingReport=new OpeningReport();
                openingReport.setId(id);
                openingReport.setStatus(status);
                int count=openingReportService.updateOpeRep(openingReport);
                if (count == 0) {
                    data = "{\"code\":\"300\",\"message\":\"失败\"}";
                } else {
                    data = "{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return data;
    }
}
