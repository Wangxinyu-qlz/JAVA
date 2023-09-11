import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class LocalDateTime_ {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);//2023-09-05T10:05:59.020

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = dateTimeFormatter.format(ldt);
		System.out.println("格式化的日期为：" + format);//格式化的日期为：2023-09-05 10:08:30

		System.out.println(ldt.getYear());//2023
		System.out.println(ldt.getMonth());//SEPTEMBER
		System.out.println(ldt.getDayOfMonth());//5
		System.out.println(ldt.getHour());//10
		System.out.println(ldt.getMinute());//18
		System.out.println(ldt.getSecond());//35

		LocalDate now = LocalDate.now();
		LocalTime now1 = LocalTime.now();
		System.out.println(now);//2023-09-05
		System.out.println(now1);//10:20:02.412

//		日期加减
		LocalDateTime localDateTime = ldt.plusDays(897);//897天之后的时间
		System.out.println(dateTimeFormatter.format(localDateTime));//2026-02-18 10:21:33

		LocalDateTime localDateTime1 = ldt.minusMinutes(1222222);//1222222分钟之前的时间
		System.out.println(dateTimeFormatter.format(localDateTime1));//2021-05-09 16:00:22
	}
}
