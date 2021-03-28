package cn.zcbigdata.mybits_demo.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/***
 * 	该类的主要功能是将对象类型，转换为layui能识别的json
 * @author Administrator
 *
 */
public class ObjtoLayJson {
	
	public static  String toJson(Object object,String[] colums) throws Exception {
		 String[] dataRow = new String[colums.length];
		//调用该Bean的get方法
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			String fistfont = fieldName.substring(0,1).toUpperCase();
			String methodname = "get"+fistfont+fieldName.substring(1);
			Method method = object.getClass().getMethod(methodname);
			if (method.invoke(object) == null) {
				dataRow[i] =  "null";
			}else {
				dataRow[i] =  method.invoke(object).toString();
			}
			System.out.println("get的输出结果："+method.invoke(object));
		}
		System.out.println(Arrays.toString(dataRow));
		
		String jsonStr = "[{\"status\":0}, {\"message\": \"成功\" }, {\"count\": 1000},{\"rows\":{\"item\":[";
		for(int i = 0; i < dataRow.length; i++) {
			String arr = "{";
			if (dataRow[i] == null || "NULL".equals(dataRow[i]) ) {
				arr += "\"\"";
			}else {
				arr += "\"" + colums[i] + "\""+":" ;
				arr +=  "\"" + dataRow[i]+"\"";
			}
			
			arr += "}";
			if( i < dataRow.length - 1 ) {
				arr += ",";
			}
			
			jsonStr += arr;
			
		}
		
		jsonStr += "]}}]";
		return jsonStr;
	}
	
	
	public static  <T> String ListtoJson(List<T> objects,String[] colums) throws Exception {
		String[][] dataRow = new String[objects.size()][colums.length];
		int count = 0;
		for (Object object : objects) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				String fistfont = fieldName.substring(0,1).toUpperCase();
				String methodname = "get"+fistfont+fieldName.substring(1);
				Method method = object.getClass().getMethod(methodname);
				if (method.invoke(object) == null) {
					dataRow[count][i] =  "null";
				}else {
					dataRow[count][i] =  method.invoke(object).toString();
				}
				
			
			}
			count += 1;
		}
	
		
		
		String jsonStr = "[{\"status\":0}, {\"message\": \"成功\" }, {\"count\": 1000},{\"rows\":{\"item\":[";
		for(int i = 0; i < dataRow.length; i++) {
			
			String arr = "{";
			for( int j = 0; j < dataRow[i].length; j++) {
				System.out.println("j======"+j);
				if(dataRow[i][j] == null || "NULL".equals(dataRow[i][j])) {
					arr += "\"\"";
				}else {
					arr += "\"" + colums[j] + "\""+":" ;
					arr +=  "\"" +dataRow[i][j] + "\"";
				}
			
				if( j < dataRow[i].length - 1 ) {
					arr += ",";
				}
			}
			arr += "}";
			if( i < dataRow.length - 1) {
				arr += ",";
			}
			
			jsonStr += arr;
		}
		jsonStr += "]}}]";
		return jsonStr;
	}
	
	public static void main(String[] args) throws Exception {
//		User user = new User();
//		user.setAge(18);
//		user.setId(1);
//		user.setPassword("123456789");
//		String[] colums = {"id","userName","Password","age"};
////		String  jsonString = toJson(user,colums);
////		System.out.println(jsonString);
//		List<Object> users = new ArrayList<Object>();
//		users.add(user);
//		users.add(user);
//		String helloString = ListtoJson(users,colums);
//		System.out.println(helloString);
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
			return "{\"code\":\"300\",\"message\":\"失败\"}";
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
