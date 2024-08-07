/**
 * @author qiaolezi
 * @version 1.0
 *try{
 * //		    代码可能有异常
 * //		} catch(Exception e) {
 * //			捕获到异常
 * //			1.异常发生时
 * //			2.系统将异常封装为Exception对象 e，传递给catch
 * //			3.得到异常对象后，程序员自己处理  添加业务逻辑
 * //			注意：没有异常，不执行catch
 * //		} finally {//finally可以不写
 * //			异常捕获/处理与否，都会执行finally
 * //			通常将释放资源的代码，放在finally
 * //		}
 */
public class Exception03_TryCatchFinally {
	public static void main(String[] args) {
//		1.异常发生之后的代码不会执行，直接进入到catch块
//		2.如果异常没有发生，顺序执行try块代码，不进入此catch
//		3.finally代码块始终被执行
//		4.如果try代码块有多个异常
//		5.可以使用多个catch代码块 分别捕获，相应处理
//		6.要求子类异常在前，父类异常在后
//		7.可以使用try finally组合，不捕获异常，程序直接崩溃。应用场景：不管是否发生异常，都执行某个业务逻辑
		try {
			String str0 = "123";
			int a0 = Integer.parseInt(str0);
			System.out.println("数字：" + a0);

			String str = "lap";
			int a = Integer.parseInt(str);
			System.out.println("数字：" + a);

			String str1 = "123";
			int a1 = Integer.parseInt(str1);
			System.out.println("数字：" + a1);

			int n1 = 10;
			int n2 = 0;
			int res = n1 / n2;
		} catch (NumberFormatException e) {
			System.out.println("数字格式异常：" + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("算数异常：" + e.getMessage());
		} finally {
			System.out.println("finally代码块被执行");
		}

		System.out.println("继续...");

		System.out.println("===================");

		try {
			int n1 = 10;
			int n2 = 0;
			int res = n1 / n2;
		} finally {
			System.out.println("finally");
		}

		System.out.println("继续...");//不执行 执行完finally 抛出ArithmeticException 直接退出
	}
}
