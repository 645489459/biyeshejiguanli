package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.Constants;
import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.StudentTitle;
import cn.zcbigdata.mybits_demo.entity.StudentTitleVo;
import cn.zcbigdata.mybits_demo.service.StudentTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/StudentTitle")
public class StudentTitleController {
    @Autowired
    private StudentTitleService studentTitleService;

    @GetMapping("/selectStuTitList")
    public String selectStuTitList(HttpSession session, HttpServletRequest request) {
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)) {
            String cno = session.getAttribute("con").toString();
            List<StudentTitleVo> studentTitleVo = studentTitleService.selectStuTitList(cno);
            String[] cloums = {"stuTitleId", "name", "sno", "cno", "content", "status"};
            data = ObjtoLayJson.listToLayJson(cloums, studentTitleVo,100L);
        }

        return data;
    }
    @GetMapping("/selectStuTit")
    public String selectStuTit(HttpSession session, HttpServletRequest request) {
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SALESMAN_STR.equals(flag)) {
            String sno = session.getAttribute("sno").toString();
            StudentTitleVo studentTitleVo = studentTitleService.selectStuTit(sno);
            String[] cloums = {"stuTitleId", "name", "sno", "cno", "content", "status"};
            data = ObjtoLayJson.objToLayJson(cloums, studentTitleVo);
        }

        return data;
    }
    @GetMapping("/updateStuTit")
    public String updateStuTit(HttpSession session, @RequestParam Integer id, @RequestParam String status) {
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            if (IsNull.checkNull(new Object[]{id, status})) {
                StudentTitle studentTitle = new StudentTitle();
                studentTitle.setId(id);
                studentTitle.setStatus(status);
                int count = studentTitleService.updateStuTit(studentTitle);
                if (count == 0) {
                    data = "{\"code\":\"300\",\"message\":\"失败\"}";
                } else {
                    data = "{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return data;
    }
    @GetMapping("/InsertStuTit")
    public String InsertStuTit(HttpSession session,HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SALESMAN_STR.equals(flag)){
            String id=request.getParameter("id");
            String sno=session.getAttribute("sno").toString();
            String content=request.getParameter("content");
            if (IsNull.checkNull(new String[]{id,content})){
                Integer Id=Integer.valueOf(id);
                StudentTitle studentTitle=new StudentTitle();
                studentTitle.setSno(sno);
                studentTitle.setId(Id);
                studentTitle.setContent(content);
                int count=studentTitleService.InsertStuTit(studentTitle);
                if (count == 0) {
                    data = "{\"code\":\"300\",\"message\":\"失败\"}";
                } else {
                    data = "{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return data;
    }
    @GetMapping("/updateTit")
    public String updateTit(HttpSession session, @RequestParam Integer id, @RequestParam String content) {
        String flag = session.getAttribute("flag").toString();
        String data = "{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SALESMAN_STR.equals(flag)){
            if (IsNull.checkNull(new Object[]{id, content})) {
                StudentTitle studentTitle = new StudentTitle();
                studentTitle.setId(id);
                studentTitle.setStatus(content);
                int count = studentTitleService.updateStuTit(studentTitle);
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
