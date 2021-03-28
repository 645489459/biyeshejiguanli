package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNullUtil;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.TeacherOpen;
import cn.zcbigdata.mybits_demo.service.TeacherOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TeacherOpenController {
    @Autowired
    public TeacherOpenService teacherOpenService;
    public final String teacherFlag = "2";
    public final String studentFlag = "4";
    public final String adminFlag = "1";

    @RequestMapping("/toBack")
    public String toBack() {
        return "back";
    }

    @ResponseBody
    @RequestMapping(value="/examStudentTitle", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String statusString = request.getParameter("status");
        String data = "";

        if(adminFlag.equals(session.getAttribute("admin_flag"))){
            if(IsNullUtil.IsNullTrue(statusString)) {
                data = "{\"data\":\"您的输入为空，请重新输入\"}";
            }else {
                TeacherOpen teacherOpen = new TeacherOpen();
                teacherOpen.setStatus(statusString);

                teacherOpenService.update(teacherOpen);

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
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        String cnoString = (String) session.getAttribute("cno");
        System.out.println(pageString + limitString);
        String data="";
        if(adminFlag.equals(session.getAttribute("admin_flag"))){
            List<TeacherOpen> listsList = teacherOpenService.selectAll(pageInteger,limitInteger,cnoString);
            if(listsList != null) {
                System.out.println("能拿到数据");
            }
            if(listsList == null) {
                System.out.println("不能拿到数据");
            }
            String[] colums = { "id", "name","sno","content","status","remark"};//获取的时候要获取全部数据

            data = ObjtoLayJson.ListtoJson(listsList, colums);
        }else{
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }


    @ResponseBody
    @RequestMapping(value = "/selectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String selectCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String cnoString = (String) session.getAttribute("cno");
        int count = teacherOpenService.selectCount(cnoString);
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
}
