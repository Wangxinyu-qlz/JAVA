package servlet.annotation;
import javax.servlet.ServletContext;
/**
 * @program: Java
 * @description: 网站访问次数统计
 * @author: Qiaolezi
 * @create: 2024-02-25 17:48
 **/
public class WebCount {
	public static Integer visitCount(ServletContext servletContext) {
		Object visitCount = servletContext.getAttribute("visit_count");
		//判断visit_count是否为null
		if (visitCount == null) {//说明是第一次访问
			visitCount = 1;
			servletContext.setAttribute("visit_count", visitCount);
			//防止第一次访问 显示的次数为null
			//visitCount = 1;
		} else {//说明是第2次及以上
			//取出visit_count属性的值再 +1
			//TODO Object -> String -> Integer -> +1 -> 存入
			visitCount = Integer.parseInt(visitCount + "") + 1;
			//visitCount = visitCount + 1;//运算符 '+' 不能应用于 'java.lang.Object'、'int'
			servletContext.setAttribute("visit_count", visitCount);
		}

		//return Integer.parseInt(visitCount + "");
		return (Integer) visitCount;
	}
}
