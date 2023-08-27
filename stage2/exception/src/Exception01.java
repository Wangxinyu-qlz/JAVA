/**
 * @author qiaolezi
 * @version 1.0
 */
public class Exception01 {
	public static void main(String[] args) {
		int a = 2;
		int b = 0;
		try {
			int c = a / b;//RunTime Error
		} catch (Exception e) {
//			throw new RuntimeException(e);
			System.out.println("抛出的异常为：" + e.getMessage());//抛出的异常为：/ by zero
		}
	}
}