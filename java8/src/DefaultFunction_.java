import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

public class DefaultFunction_ {
	public static void main(String[] args){

	}
}

interface Animal{
	default void print(){
		System.out.println("我是动物！");
	}
}

interface Horse{
	default void print(){
		System.out.println("我是马！");
	}
}

//必须实现接口的方法，实现自己的默认方法覆盖实现的接口的方法，或者指定某个接口的方法
class Animal_ implements Animal, Horse{
	//指定接口的默认方法
	@Override
	public void print() {
		Animal.super.print();
	}

	//创建自己的默认方法，覆盖接口的默认方法
	//default void print(){
	//	System.out.println("我是一只小动物！");
	//}
}


