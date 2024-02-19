public class Constructor_ {
	public static void main(String[] args){
		Employee e = new Employee("123");
		System.out.println(e.empID);
	}
}

class Person{
	String name = "No name";
	public Person(String nm){
		name = nm;
	}

	//TODO 子类继承父类，子类的构造方法总是会先调用父类的构造方法
	// 如果子类的构造方法没有明显的指定调用那个父类的构造方法，子类会调用父类的无参构造器
	// 如果父类中没有无参构造器，就会编译报错
	// 这时，子类需要显示的调用父类的构造器
	//Person() {}
}

class Employee extends Person{
	String empID = "0000";
	public Employee(String id){
		super(id);//父类中只有显式的有参构造器
		//super();//父类中有显式的无参构造器和有参构造器
		empID = id;
	}


}