/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-09-09 10:27
 * @description:
 **/
public class Father_ {
	private String name = "father_";
	int age= 0;
}

class Child_ extends Father_ {
	public String grade;

	public static void main(String[] args) {
		Father_ father = new Father_();

		//TODo 子类的作用域中，无法访问父类的私有变量
		//System.out.println(father.name);
	}
}
