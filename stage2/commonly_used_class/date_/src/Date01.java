import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Date01 {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("当前日期为：" + date);//当前日期为：Tue Sep 05 09:07:50 CST 2023
		Date date1 = new Date(684635468);
		System.out.println("日期为：" + date1);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
//		将日期转换为指定格式的字符串
		String format = simpleDateFormat.format(date);
		System.out.println("当前时间为:" + format);//当前时间为:2023年09月05日 09:07:50 星期二

//		将格式化的String转换为对应的Date
//		s的日期格式需要和 new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E")中的格式一致
		String s = "1996年01月01日 10:20:40 星期六";
		Date parse = simpleDateFormat.parse(s);
//		得到的日期为国外格式，需要转换
		System.out.println(parse);//Mon Jan 01 10:20:40 CST 1996
		System.out.println("parse:" + simpleDateFormat.format(parse));//parse:1996年01月01日 10:20:40 星期一


	}
}

