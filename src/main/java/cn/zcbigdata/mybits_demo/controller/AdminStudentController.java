package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNullUtil;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.AdminStudent;
import cn.zcbigdata.mybits_demo.service.AdminStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminStudentController {
    @Autowired
    public AdminStudentService adminStudentService;
    public final String teacherFlag = "2";
    public final String studentFlag = "4";
    public final String adminFlag = "1";

    @RequestMapping("/toBack")
    public String toBack() {
        return "back";
    }

    @ResponseBody
    @RequestMapping(value="/regist", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String regist(HttpServletRequest request) {

        String nameString = request.getParameter("name");
        String passwordString = request.getParameter("password");
        String snoString = request.getParameter("sno");
        String data = "";
        if(IsNullUtil.IsNullTrue(nameString) && IsNullUtil.IsNullTrue(passwordString) && IsNullUtil.IsNullTrue(snoString)) {
            data = "{\"data\":\"您的输入为空，请重新输入\"}";
        }else {
            System.out.println(nameString);
            AdminStudent adminStudent = new AdminStudent();
            adminStudent.setPassword(passwordString);
            adminStudent.setName(nameString);
            adminStudent.setSno(snoString);

            adminStudentService.regist(adminStudent);

            data = "{\"data\":\"注册成功\"}";
        }
        return data;
    }


    @SuppressWarnings("unused")
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    protected String doGet(HttpServletRequest request) throws Exception{

        String snoString = request.getParameter("sno");
        String passwordString = request.getParameter("password");
        System.out.println(snoString + "************"+passwordString);

        String data = "";

        if(IsNullUtil.IsNullTrue(snoString)) {
            System.out.println("用户名为空");
            data = "{\"data\":\"用户名为空\"}";

        }else if (IsNullUtil.IsNullTrue(passwordString)) {
            System.out.println("密码为空");
            data = "{\"data\":\"密码为空\"}";

        }else {
            AdminStudent adminStudent = adminStudentService.login(snoString,passwordString);
            System.out.println(adminStudentService.login(snoString,passwordString));//在adminStudent为空的情况下不能用toString方法
            if(adminStudent != null){
                data = "{\"data\":\"登录成功\"}";
                HttpSession session1 = request.getSession();
                HttpSession session2 = request.getSession();
                session1.setAttribute("sno", adminStudent.getSno());
                session2.setAttribute("student_flag", adminStudent.getFlag());
            }else {
                data = "{\"data\":\"用户名或密码错误\"}";
            }
        }
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/insert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request) {
        HttpSession session2=request.getSession();
        String nameString = request.getParameter("name");
        String passwordString = request.getParameter("password");
        String snoString = request.getParameter("sno");
        String data = "";

        if(adminFlag.equals(session2.getAttribute("admin_flag"))){
            if(IsNullUtil.IsNullTrue(nameString) && IsNullUtil.IsNullTrue(passwordString) && IsNullUtil.IsNullTrue(snoString)) {
                data = "{\"data\":\"您的输入为空，请重新输入\"}";
            }else {
                System.out.println(nameString);
                AdminStudent adminStudent = new AdminStudent();
                adminStudent.setPassword(passwordString);
                adminStudent.setName(nameString);
                adminStudent.setSno(snoString);

                adminStudentService.insert(adminStudent);

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
        HttpSession session2=request.getSession();
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        String data="";
        if(adminFlag.equals(session2.getAttribute("admin_flag"))){
            List<AdminStudent> listsList = adminStudentService.selectAll(pageInteger,limitInteger);
            if(listsList != null) {
                System.out.println("能拿到数据");
            }
            if(listsList == null) {
                System.out.println("不能拿到数据");
            }
            String[] colums = { "id", "name", "password", "sno","cno","flag"};//获取的时候要获取全部数据

            data = ObjtoLayJson.ListtoJson(listsList, colums);
        }else{
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }


    @ResponseBody
    @RequestMapping(value = "/selectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String SelectCount(HttpServletRequest request) {
        int count = adminStudentService.selectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/delete", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String deleteByPrimaryKey(HttpServletRequest request) {
        String  idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        String data="";
        HttpSession session2=request.getSession();
        if(adminFlag.equals(session2.getAttribute("admin_flag"))){
            adminStudentService.delete(idInteger);
            data = "{\"data\":\"删除成功\"}";
        }else {
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        String idString = request.getParameter("id");
        String nameString = request.getParameter("name");
        String passwordString = request.getParameter("password");
        String snoString = request.getParameter("sno");
        Integer idInteger = Integer.valueOf(idString);
        String data = "";
        HttpSession session2=request.getSession();
        if(adminFlag.equals(session2.getAttribute("admin_flag"))){
            AdminStudent adminStudent = new AdminStudent();
            adminStudent.setId(idInteger);
            adminStudent.setPassword(passwordString);
            adminStudent.setName(nameString);
            adminStudent.setSno(snoString);

            adminStudentService.update(adminStudent);


            data = "{\"data\":\"修改成功\"}";
        }else {
            data = "{\"data\":\"管理员身份验证错误\"}";
        }
        return data;
    }
}
