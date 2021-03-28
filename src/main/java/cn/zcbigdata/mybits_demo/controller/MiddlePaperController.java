package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.Constants;
import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.MiddlePaper;
import cn.zcbigdata.mybits_demo.entity.ReportPaperVo;
import cn.zcbigdata.mybits_demo.service.MiddlePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/MiddlePaper")
public class MiddlePaperController {
    @Autowired
    private MiddlePaperService middlePaperService;
    @GetMapping("/selectMidPapList")
    public String selectMidPapList(HttpSession session){
        String flag=session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            String cno=session.getAttribute("cno").toString();
            List<ReportPaperVo> openingReportVos=middlePaperService.selectMidPapList(cno);
            String[] cloums={"ope_title_id","sno","name","cno","cnotent","remark","status"};
            data= ObjtoLayJson.objectToJson(cloums,openingReportVos);
        }
        return data;
    }
    @GetMapping("/updateMidPap")
    public String updateMidPap(HttpSession session, @RequestParam Integer id, @RequestParam String status){
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            if (IsNull.checkNull(new Object[]{id, status})) {
                MiddlePaper middlePaper=new MiddlePaper();
                middlePaper.setId(id);
                middlePaper.setStatus(status);
                int count=middlePaperService.updateMidPap(middlePaper);
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
