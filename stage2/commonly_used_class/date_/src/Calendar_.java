import java.util.Calendar;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Calendar_ {
	public static void main(String[] args) {
//		Calendar是一个抽象类，构造器是private
//		可以通过 getInstance() 获取实例
//		提供了大量的方法和字段
		Calendar c = Calendar.getInstance();//日历对象类
		System.out.println(c);
//		获取日历对象的某个日历字段
		System.out.println("年：" + c.get(Calendar.YEAR));//2023
//		这里要 +1 ,Calendar返回月份时，从0开始
		System.out.println("月：" + (c.get(Calendar.MONTH) + 1));//9
		System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));//5
		System.out.println("时：" + c.get(Calendar.HOUR));//9
		System.out.println("时：" + c.get(Calendar.HOUR_OF_DAY));//24小时制
		System.out.println("分：" + c.get(Calendar.MINUTE));//57
		System.out.println("秒：" + c.get(Calendar.SECOND));
		System.out.println("=================");
//		2023年9月5日 10点1分49秒
		System.out.print(c.get(Calendar.YEAR) + "年" +(c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DAY_OF_MONTH) +
				"日 " + c.get(Calendar.HOUR) + "点" + c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒");
	}
}
