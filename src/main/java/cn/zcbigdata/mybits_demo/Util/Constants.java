package cn.zcbigdata.mybits_demo.Util;

/**
 * @author 
 * @program salesManagementSystem
 * @description 常量字典
 * @date 2021-02-24 22:43
 **/

public class Constants {
    public static final Integer ROLE_SUPER_ADMIN = 1;
    public static final String ROLE_SUPER_ADMIN_STR = "1";
    public static final Integer ROLE_SHOP_ADMIN = 2;
    public static final String ROLE_SHOP_ADMIN_STR = "2";
    public static final Integer ROLE_SALESMAN = 4;
    public static final String ROLE_SALESMAN_STR = "4";
    public static final Integer ROLE_ALL = 7;
    public static final String ROLE_ALL_STR = "7";
    /**
     * 参数为空的返回值
     */
    public static final String IS_NULL_RETURN_JSON = "{\"code\":400,\"msg\":\"缺少参数\"}";
    /**
     * 用户没有被启用的返回值
     */
    public static final String USERN_NOT_ENABLE_JSON = "{\"code\":401,\"msg\":\"用户没有被启用\"}";
    /**
     * 成功的返回值
     */
    public static final String SUCCESS_RETURN_JSON = "{\"code\":200,\"msg\":\"操作成功\"}";
    /**
     * 失败的返回值
     */
    public static final String FAIL_RETURN_JSON = "{\"code\":500,\"msg\":\"操作失败\"}";
    /**
     * 没有登录的返回值
     */
    public static final String NO_LOGIN_RETURN_JSON = "{\"code\":401,\"msg\":\"没有登录或无权访问\"}";
    /**
     * 数据已存在的返回值
     */
    public static final String DATA_ALREADY_EXISTS_JSON = "{\"code\":20001,\"msg\":\"数据已存在\"}";
}
