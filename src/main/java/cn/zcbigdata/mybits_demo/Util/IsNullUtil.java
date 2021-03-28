package cn.zcbigdata.mybits_demo.Util;

public class IsNullUtil {

	public static boolean IsNull(String str) {
		if(null!=str&&str.length()>0) {
			return true;
		}else {
		return false;
		}
	}
	public static boolean IsNullTrue(String str) {
		
		if(str.length()<=0 || str==null ) {
			return true;
			
		}else {
			return false;
		}
	}

    public static boolean checkNull(Object[] args) {
        for (Object arg : args) {
            if (arg == null || arg.toString().trim().length() <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNull(Object arg) {
        return arg == null && arg.toString().trim().length() <= 0;
    }
}