package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.Constants;
import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.TeacherContent;
import cn.zcbigdata.mybits_demo.service.TeacherContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacherContent")
public class TeacherContentController {
    @Autowired
    private TeacherContentService teacherContentService;
    @GetMapping("/selectTcn")
    public String selectTcn(HttpSession session, HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IsNull.checkNull(flag)){
            String cno=session.getAttribute("cno").toString();
            TeacherContent teacherContent=teacherContentService.selectTcn(cno);
            String[] cloums={"id","cno","content"};
            data= ObjtoLayJson.objectToJson(cloums,teacherContent);
        }
        return data;

    }
    @GetMapping("insertTcn")
    public String insertTcn(HttpSession session,HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (Constants.ROLE_SHOP_ADMIN_STR.equals(flag)){
            String cno=session.getAttribute("cno").toString();
            String cnotent=request.getParameter("content");
            if (IsNull.checkNull(cnotent)){
                TeacherContent teacherContent=new TeacherContent();
                teacherContent.setContent(cnotent);
                teacherContent.setCno(cno);
                int count=teacherContentService.insertTcn(teacherContent);
                if (count==0){
                    data="{\"code\":\"300\",\"message\":\"失败\"}";
                }
                else {
                    data="{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return data;
    }
}
