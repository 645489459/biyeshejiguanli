package cn.zcbigdata.mybits_demo.Util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Json工具类
 *
 * @author yty
 */
public class ObjtoLayJson {

	/**
	 * 将list转换为layui风格的json
	 *
	 * @param fields String数组形式的字段列表
	 * @param data   传入的列表，内容需要为javaBean格式的类
	 * @return 返回转换好的json
	 * @throws Exception 传入的字段列表或list内的对象格式不对抛出异常
	 */
	public static String listToLayJson(String[] fields, List<?> data, Long count) {
		StringBuilder re = new StringBuilder();
		if(count == null){
			count = (long) data.size();
		}
		re.append("{\"code\":0,\"msg\":\"获取成功\",\"count\":");
		re.append(count);
		re.append(",\"data\":[");
		if (data.isEmpty()) {
			re.append("]}");
			return re.toString();
		}
		for (Object object : data) {
			try{
				re.append(beanToJson(fields, object));
			}catch (Exception e){
				e.printStackTrace();
				return Constants.FAIL_RETURN_JSON;
			}
			re.append(',');
		}
		re.deleteCharAt(re.length() - 1);
		re.append("]}");
		return re.toString();
	}
	/**
	 * 将Object转换为layui风格的json
	 *
	 * @param fields String数组形式的字段列表
	 * @param data   传入的列表，内容需要为javaBean格式的类
	 * @return 返回转换好的json
	 * @throws Exception 传入的字段列表或list内的对象格式不对抛出异常
	 */
	public static String objToLayJson(String[] fields, Object data) {
		Long count=1L;
		StringBuilder re = new StringBuilder();
		re.append("{\"code\":0,\"msg\":\"获取成功\",\"count\":");
		re.append(count);
		re.append(",\"data\":[");
		if (data==null) {
			re.append("]}");
			return re.toString();
		}

			try{
				re.append(beanToJson(fields, data));
			}catch (Exception e){
				e.printStackTrace();
				return Constants.FAIL_RETURN_JSON;
			}
			re.append(',');

		re.deleteCharAt(re.length() - 1);
		re.append("]}");
		return re.toString();
	}

	/**
	 * 将list转换为json
	 *
	 * @param fields String数组形式的字段列表
	 * @param data   传入的列表，内容需要为javaBean格式的类
	 * @return 返回转换好的json
	 */
	public static String listToJson(String[] fields, List<?> data) {
		StringBuilder re = new StringBuilder();
		re.append("{\"code\":200,\"msg\":\"成功\",\"data\":[");
		if (data == null || data.isEmpty()) {
			re.append("]}");
			return re.toString();
		}
		for (Object object : data) {
			try {
				re.append(beanToJson(fields, object));
				re.append(',');
			} catch (Exception e) {
				e.printStackTrace();
				return Constants.FAIL_RETURN_JSON;
			}
		}
		re.deleteCharAt(re.length() - 1);
		re.append("]}");
		return re.toString();
	}

	/**
	 * 将javaBean对象转换为带有状态码和消息的json
	 *
	 * @param fields String数组形式的字段列表
	 * @param object 传入的javaBean对象
	 * @return 返回转换好的json
	 */
	public static String objectToJson(String[] fields, Object object){
		try{
			return "{\"code\":200,\"msg\":\"成功\",\"data\":" + beanToJson(fields, object) + '}';
		}catch (Exception e){
			e.printStackTrace();
			return Constants.FAIL_RETURN_JSON;
		}

	}

	/**
	 * 将javaBean对象转换为简单的json
	 *
	 * @param fields String数组形式的字段列表
	 * @param object 传入的javaBean对象
	 * @return 返回转换好的json
	 * @throws Exception 传入的字段列表或对象格式不对抛出异常
	 */
	public static String beanToJson(String[] fields, Object object) throws Exception {
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append('{');
		for (String field : fields) {
			jsonStr.append('\"').append(field).append("\":\"");
			// 根据传入的字段列表拼接get方法名
			String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
			Method method = object.getClass().getDeclaredMethod(methodName);
			// 通过反射获取数据
			Object tmp = method.invoke(object);
			String str;
			// 判空
			if (tmp != null) {
				str = tmp.toString();
			} else {
				str = "";
			}
			// 转义数据中的双引号，防止破坏json格式
			if (str.contains("\"")) {
				char[] arr = str.toCharArray();
				for (char c : arr) {
					if (c == '\"') {
						jsonStr.append('\\');
					}
					jsonStr.append(c);
				}
			} else {
				jsonStr.append(str);
			}
			jsonStr.append("\",");
		}
		// 删除多余逗号
		jsonStr.deleteCharAt(jsonStr.length() - 1);
		jsonStr.append('}');
		return jsonStr.toString();
	}

}
