package cn.zcbigdata.mybits_demo.Util;

public class IsNull {
    /**
     * 用于判空的方法
     *
     * @param args 将参数整合为Object数组传入
     * @return 有空值时返回false，没有空值返回true
     */
    public static boolean checkNull(Object[] args) {
        for (Object arg : args) {
            if (arg == null || arg.toString().trim().length() <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNull(Object arg) {
        return arg != null && arg.toString().trim().length() > 0;
    }
}

