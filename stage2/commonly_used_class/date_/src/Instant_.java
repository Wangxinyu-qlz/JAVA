import java.util.Date;
import java.time.Instant;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Instant_ {
	public static void main(String[] args) {
//		时间戳
		Instant now = Instant.now();
		System.out.println(now);//2023-09-05T02:23:42.938Z

		Date from = Date.from(now);
		System.out.println(from);//Tue Sep 05 10:29:26 CST 2023

		Instant instant = from.toInstant();
		System.out.println(instant);//2023-09-05T02:30:09.735Z
	}
}
