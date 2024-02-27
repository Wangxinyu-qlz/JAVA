package tomcat.utils;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 17:44
 * @description:字符串转换为数字
 **/
public class WebUtils {
	public static int stringToInt(String s, int defaultValue) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("不能转换为数字！");
		}
		return defaultValue;
	}
}
