package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.Util.SessionUtils;
import cn.zcbigdata.mybits_demo.entity.Admin;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.service.AdminService;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author admin
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private StudentService studentService;
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String login() throws Exception {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegist() throws Exception {
        return "regist";
    }

    @RequestMapping("/studentLogin")
    @ResponseBody
    public String studentLogin(HttpServletRequest request)  {
        String data = "";
        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        if (!IsNull.checkNull(new String[]{sno, password})) {
            data = "{\"code\":\"300\",\"message\":\"登陆失败\"}";
            return data;
        }
        Student student = new Student();
        student.setSno(sno);
        student.setPassword(password);
        String[] cloums = {"id", "name",  "sno", "cno"};
        student = studentService.loginSelect(student);

        if (IsNull.checkNull(student)) {
            HttpSession session = request.getSession();
            session.setAttribute("flag", student.getFlag());
            session.setAttribute("sno", student.getSno());
            return ObjtoLayJson.objectToJson(cloums,student);
        } else {
            data = "{\"code\":\"300\",\"message\":\"登录失败,请检查用户名和密码\"}";
            return data;
        }
    }
    @RequestMapping("/teacherLogin")
    @ResponseBody
    public String teacherLogin(HttpServletRequest request)  {
        String data = "";
        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        if (!IsNull.checkNull(new String[]{sno, password})) {
            data = "{\"code\":\"300\",\"message\":\"登陆失败\"}";
            return data;
        }
        Student student = new Student();
        student.setSno(sno);
        student.setPassword(password);
        String[] cloums = {"id", "name",  "sno", "cno"};
        student = studentService.loginSelect(student);

        if (IsNull.checkNull(student)) {
            HttpSession session = request.getSession();
            session.setAttribute("flag", student.getFlag());
            session.setAttribute("sno", student.getSno());
            return ObjtoLayJson.objectToJson(cloums,student);
        } else {
            data = "{\"code\":\"300\",\"message\":\"登录失败,请检查用户名和密码\"}";
            return data;
        }
    }
    @GetMapping("/adminLogin")
    public String adminLogin(HttpServletRequest request){
        String data="";
        String cno=request.getParameter("cno");
        String password=request.getParameter("password");
        if (!IsNull.checkNull(new String[] {cno,password})){
            data = "{\"code\":\"300\",\"message\":\"登陆失败\"}";
            return data;
        }
        Admin admin=new Admin();
        admin.setCno(cno);
        admin.setPassword(password);
        String[] cloums={"id","name","cno"};
        admin=adminService.adminLogin(admin);
        if (IsNull.checkNull(admin)){
            HttpSession session=request.getSession();
            session.setAttribute("cno",admin.getCno());
            session.setAttribute("flag",admin.getFlag());
            return ObjtoLayJson.objectToJson(cloums,admin);
        }
        else {
            data = "{\"code\":\"300\",\"message\":\"登录失败,请检查用户名和密码\"}";
            return data;
        }
    }
    @GetMapping("/regist")
    public String regist(HttpSession session,HttpServletRequest request){
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String sno=request.getParameter("sno");
            String cno=request.getParameter("cno");
            if(IsNull.checkNull(new String[]{name,password,sno,cno})) {
                Student student = new Student();
                student.setName(name);
                student.setPassword(password);
                student.setSno(sno);
                student.setCno(cno);
                int count=studentService.InsertStu(student);
                if (count==0){
                    data="{\"code\":\"300\",\"message\":\"失败\"}";
                }
                else {
                    data="{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }

        return data;
    }
}
