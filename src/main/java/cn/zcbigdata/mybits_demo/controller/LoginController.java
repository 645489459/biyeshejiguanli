package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
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

/**
 * @author admin
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String login(HttpSession session)  {
        session.invalidate();
        return "login";
    }
    @RequestMapping("/tostudent")
    public String student()  {
        return "sutdent";
    }
    @RequestMapping("/tostustu")
    public String stustu()  {
        return "stustu";
    }

    @RequestMapping("/toRegister")
    public String toRegist()  {
        return "regist";
    }
    @RequestMapping("/tostutit")
    public String tostutit()  {
        return "stutit";
    }

}
