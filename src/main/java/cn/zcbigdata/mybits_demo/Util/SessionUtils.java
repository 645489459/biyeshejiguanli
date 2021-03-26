package cn.zcbigdata.mybits_demo.Util;

import javax.servlet.http.HttpSession;

public class SessionUtils {
    /**
     * 用于检查是否登录的方法
     *
     * @param session 一个HttpSession对象
     * @param roleId    期望的用户类型：1-系统管理员；2-门店管理员；3-系统管理员+门店管理员；4-销售人员；5-系统管理员+销售人员；6-门店管理员+销售人员；7-所有登录用户
     * @return 用户已经登录返回true，否则返回false
     */
    public static boolean checkLogin(HttpSession session, int roleId) {
        String useridStr = (String) session.getAttribute("userId");
        String roleIdStr = (String) session.getAttribute("roleId");
        if (useridStr == null || roleIdStr == null) {
            return false;
        }
        switch (roleId) {
            case 1:
            case 2:
            case 4:
                return Long.parseLong(roleIdStr) == roleId;
            case 3:
                return (Long.parseLong(roleIdStr) == 1 || Long.parseLong(roleIdStr) == 2);
            case 5:
                return (Long.parseLong(roleIdStr) == 1 || Long.parseLong(roleIdStr) == 4);
            case 6:
                return (Long.parseLong(roleIdStr) == 2 || Long.parseLong(roleIdStr) == 4);
            case 7:
                return true;
            default:
                return false;
        }
    }

}
