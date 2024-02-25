package utils;

public class WebUtils {
	public static int parerInt(String strNum, int defaultVal){

		try {
			return Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			System.out.println("格式不对，转换失败");
		}

		return defaultVal;
	}
}
