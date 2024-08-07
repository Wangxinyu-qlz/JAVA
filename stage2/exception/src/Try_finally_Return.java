/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-07 09:49
 * @description:
 * 不要在 finally 语句块中使用 return!
 * 当 try 语句和 finally 语句中都有 return 语句时，
 * try 语句块中的 return 语句会被忽略。
 * 这是因为 try 语句中的 return 返回值会先被暂存在一个本地变量中，
 * 当执行到 finally 语句中的 return 之后，
 * 这个本地变量的值就变为了 finally 语句中的 return 返回值。
 **/
public class Try_finally_Return {
	public static void main(String[] args) {
		//TODO 没有达到预期结果，返回值为0
		System.out.println(f(2));
	}

	public static int f(int v) {
		try{
			return v + v;
		} finally {
			if(v == 2) {
				return 0;
			}
		}
	}
}
