/*
	函数式接口 Functional Interface
	有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
	函数式接口可以被隐式转换为 lambda 表达式。
 */
public class FunctionalInterface_ {
	public static void main(String[] args){
		Hi hi = message -> System.out.println("Hello " + message);
		hi.sayMessage("你好");
		hi.say("1");

	}
}

@FunctionalInterface
interface Hi {
	void sayMessage(String message);
	default void say(String message){
		System.out.println(message);
	}
}