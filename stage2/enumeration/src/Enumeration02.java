/**
 * @author qiaolezi
 * @version 1.0
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);

		Gender boy = Gender.BOY;
		Gender boy2 = Gender.BOY;
		//BOY  本质是调用Gender的父类（java.lang.Enum）的toString()方法
//	    Enum  public String toString() {
//        return name;
//      }
	    System.out.println(boy);
	    System.out.println(boy == boy2);//true 静态对象
    }
}

enum Season2 {
//    public final static Season SPRING = new Season("春天", "温暖");
//    public final static Season SUMMER = new Season("夏天", "炎热");
//    public final static Season AUTUMN = new Season("秋天", "凉爽");
//    public final static Season WINTER = new Season("冬天", "寒冷");

//	如何使用enum 实现枚举类
//	1.使用关键字 enum 替换 class
//	2.解读： SPRING("春天", "温暖") 常量名(实参列表)
//	3.TODO 如果有多个常量（对象），使用','间隔
//	4.TODO 如果使用 enum 实现枚举类，要求将对象写在最前面
//	5.如果使用无参构造器，创建对象常量，可以省略 "()"
	WHAT(),HOW,
	SPRING("春天", "温暖"),SUMMER("夏天", "酷热"),
	AUTUMN("秋天", "凉爽"),WINTER("冬天", "寒冷");
	private String name;
    private String desc;

	Season2(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	private Season2() {}

	public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

enum Gender {
	BOY,GIRL;//调用无参构造器
}