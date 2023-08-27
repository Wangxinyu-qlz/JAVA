/**
 * @author qiaolezi
 * @version 1.0
 */
public class Exception05_Custom {
	public static void main(String[] args) {
		int age = 80;
		if(!(age >= 18 && age <= 120)) {
			throw new AgeException("年龄应该在18-120之间！");
		}

		System.out.println("你的年龄符合要求！");
	}
}

//自定义异常
//运行时异常 主要原因是很方便
class AgeException extends RuntimeException {
	public AgeException(String message) {
		super(message);
	}
}