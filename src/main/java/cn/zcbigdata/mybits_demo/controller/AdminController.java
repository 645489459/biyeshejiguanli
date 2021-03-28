package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.Admin;
import cn.zcbigdata.mybits_demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author admin
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    private static final String IS_ADMIN="1";
    @GetMapping("/selectAllAdm")
    public String selectAllAdm(HttpSession session) throws Exception {
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            List<Admin> admins=adminService.selectAllAdm();
            String []cloms={"id","name","password","cno","flag"};
            data= ObjtoLayJson.ListtoJson(admins,cloms);
        }

        return data;
    }
    @GetMapping("/InsertAdm")
    public String InsertAdm(HttpSession session, HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String cno=request.getParameter("cno");
            if(IsNull.checkNull(new  String[]{name,password,cno} )){
                Admin admin=new Admin();
                admin.setName(name);
                admin.setPassword(password);
                admin.setCno(cno);
                int count=adminService.InsertAdm(admin);
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
    @GetMapping("/UpdateAdm")
    public String UpdateAdm(HttpSession session,HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String cno=request.getParameter("cno");
            if(IsNull.checkNull(new  String[]{name,password,cno} )){
                Admin admin=new Admin();
                admin.setName(name);
                admin.setPassword(password);
                admin.setCno(cno);
                int count=adminService.UpdateAdm(admin);
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
    @GetMapping("/DeleteAdm")
    public String DeleteAdm(HttpSession session,HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            String id=request.getParameter("id");
            if (IsNull.checkNull(id)){
                Integer Id=Integer.valueOf(id);
                int count=adminService.DeleteAdm(Id);
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
