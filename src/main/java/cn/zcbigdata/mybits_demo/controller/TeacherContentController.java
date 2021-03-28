package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNullUtil;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.TeacherContent;
import cn.zcbigdata.mybits_demo.service.TeacherContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TeacherContentController {
    public final String teacherFlag = "2";
    public final String studentFlag = "4";
    public final String adminFlag = "1";
    @Autowired
    public cn.zcbigdata.mybits_demo.service.TeacherContentService TeacherContentService;
    @ResponseBody
    @RequestMapping(value="/update", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String contentString = request.getParameter("content");
        String data = "";

        if(adminFlag.equals(session.getAttribute("admin_flag"))){
            if(IsNullUtil.IsNullTrue(contentString)) {
                data = "{\"data\":\"您的输入为空，请重新输入\"}";
            }else {
                TeacherContent teacherContent = new TeacherContent();
                teacherContent.setContent(contentString);

                TeacherContentService.update(teacherContent);

                data = "{\"data\":\"增加成功\"}";
            }
        }else{
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }
    @ResponseBody
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        String cnoString = (String) session.getAttribute("cno");
        String data="";
        if(adminFlag.equals(session.getAttribute("admin_flag"))){
            List<TeacherContent> listsList = TeacherContentService.selectAll(cnoString);
            if(listsList != null) {
                System.out.println("能拿到数据");
            }
            if(listsList == null) {
                System.out.println("不能拿到数据");
            }
            String[] colums = { "id", "content"};//获取的时候要获取全部数据

            data = ObjtoLayJson.ListtoJson(listsList, colums);
        }else{
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }
}
