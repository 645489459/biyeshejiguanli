package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.IsNull;
import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.Util.SessionUtils;
import cn.zcbigdata.mybits_demo.entity.SystemContent;
import cn.zcbigdata.mybits_demo.service.SystemContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author admin
 */
@RestController
@RequestMapping("/systemConent")
public class SystemConentController {
    @Autowired
    private SystemContentService systemContentService;
    private static final String IS_ADMIN="1";
    @GetMapping("/selectSys")
    public String selectSys(HttpSession session) throws Exception {
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (SessionUtils.checkLogin(session,7)){
            String []cloums={"id","content"};
            List<SystemContent> systemContents=systemContentService.selectSys();
            data= ObjtoLayJson.listToLayJson(cloums,systemContents,100L);
        }

        return data;
    }
    @GetMapping("/insertSys")
    public String insertSys(HttpSession session, HttpServletRequest request){
        String flag=session.getAttribute("flag").toString();
        String data="{\"code\":\"300\",\"message\":\"失败\"}";
        if (IS_ADMIN.equals(flag)){
            String content=request.getParameter("content");
            if (IsNull.checkNull(content)){
                SystemContent systemContent=new SystemContent();
                systemContent.setContent(content);
                int count=systemContentService.insertSys(systemContent);
                if (count==0){
                    data="{\"code\":\"300\",\"message\":\"失败\"}";
                }
                else {
                    data="{\"code\":\"200\",\"message\":\"成功\"}";
                }
            }
        }
        return  data;
    }
}
