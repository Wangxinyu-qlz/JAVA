import java.util.Arrays;

/**
 * @author qiaolezi
 * @version 1.0
 * TODO 内存布局很重要！！！要理解
 */
public class String04 {
	public static void main(String[] args) {
		Test1 ex = new Test1();
		ex.change(ex.str, ex.ch);
//		hspandhava
		System.out.print(ex.str + "and");
		System.out.println(ex.ch);

//      hspand[C@1b6d3586
		System.out.println(ex.str + "and" + ex.ch);

//		hspand[h, a, v, a]
		System.out.println(ex.str + "and" + Arrays.toString(ex.ch));
	}
}

class Test1 {
	String str = new String("hsp");
	final char[] ch = {'j', 'a', 'v', 'a'};

	public void change(String str, char ch[]) {
//		这里的str一开始指向堆中的value（main栈:ex->堆：str->堆：value）
//		执行str = "java";语句后，str指向常量池中的"java"
		str = "java";
		ch[0] = 'h';
	}
}
