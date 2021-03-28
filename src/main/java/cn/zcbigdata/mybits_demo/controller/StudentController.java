package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.Util.SessionUtils;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final String IS_ADMIN="1" ;
    private static final String IS_TEACHER="2" ;
    private static final String IS_STUDENT="4" ;
    @GetMapping("/selectAllStu")
    public String selectAllStu(HttpSession session) throws Exception {
        //String flag = session.getAttribute("flag").toString();
       String data="{\"code\":\"300\",\"message\":\"失败\"}";
        //if(IS_ADMIN.equals(flag)){
            List<Student> students = studentService.selectAllStu();
            String[] colums={"id","name","password","sno","cno","flag"};
            data= ObjtoLayJson.ListtoJson(students,colums);
       // }
        return data;
    }
    @GetMapping("/teacherSelectStu")
    public String teacherSelectStu(HttpSession session, HttpServletRequest request) throws Exception {
        String flag = session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_TEACHER.equals(flag)){
            String cno=session.getAttribute("cno").toString();
            List<Student> students=studentService.teacherSelectStu(cno);
            String[] colums={"id","name","password","sno","cno","flag"};
            data=ObjtoLayJson.ListtoJson(students,colums);
        }
        return data;
    }
    @GetMapping("/studentSelectStu")
    public String studentSelectStu(HttpSession session,HttpServletRequest request) throws Exception {
        String flag = session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_STUDENT.equals(flag)){
            String sno=session.getAttribute("sno").toString();
            Student student= studentService.studentSelectStu(sno);
            String[] colums={"id","name","password","sno","cno","flag"};
            data=ObjtoLayJson.toJson(student,colums);
        }

        return data;
    }
    @GetMapping("/InsertStu")
    public String InsertStu(HttpSession session,HttpServletRequest request){
        String flag = session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (SessionUtils.checkLogin(session,3)){
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
        }
        return data;
    }
    @GetMapping("/UpdateStu")
    public String UpdateStu(HttpSession session,HttpServletRequest request){
        String flag = session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (SessionUtils.checkLogin(session,3)){
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
                int cont=studentService.UpdateStu(student);
                if (cont==0){
                    data="{\"code\":\"300\",\"message\":\"失败\"}";
                }
                else {
                    data="{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return data;
    }
    @GetMapping("/deleteStu")
    public String deleteStu(HttpSession session,HttpServletRequest request){
        String flag = session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            String id=request.getParameter("id");
            if (IsNull.checkNull(id)){
                Integer Id=Integer.valueOf(id);
                int cont=studentService.deleteStu(Id);
                if (cont==0){
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
