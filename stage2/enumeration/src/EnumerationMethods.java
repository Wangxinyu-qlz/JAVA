import java.util.Arrays;

/**
 * @author qiaolezi
 * @version 1.0
 * 演示Enum类的方法使用
 */
public class EnumerationMethods {
	public static void main(String[] args) {
		Season3 autumn = Season3.AUTUMN;
//		输出枚举对象的名称
		System.out.println(autumn.name());//AUTUMN
//      输出该枚举对象的次序/编号，TODO 从0开始
		System.out.println(autumn.ordinal());//2->第三个
//      返回Season3[]
//		[Season{name='春天', desc='温暖'}, Season{name='夏天', desc='酷热'}, Season{name='秋天', desc='凉爽'}, Season{name='冬天', desc='寒冷'}]
		System.out.println(Arrays.toString(Season3.values()));
		/*
		* Season{name='春天', desc='温暖'}
		* Season{name='夏天', desc='酷热'}
		* Season{name='秋天', desc='凉爽'}
		* Season{name='冬天', desc='寒冷'}
		* */
		Season3[] values = Season3.values();
		for (Season3 season: values) {
			System.out.println(season);
		}
//      将字符串转换为对象，要求字符串必须为已有的常量名，否则抛出异常
//		1.根据输入的 "AUTUMN" 到 Season3 的枚举对象查找
//		2.如果找到了就返回，没找到就报错
//		Season{name='秋天', desc='凉爽'}
		Season3 autumn1 = Season3.valueOf("AUTUMN");
		System.out.println(autumn1);
		System.out.println(autumn1 == autumn);//true
//		比较两个枚举对象的编号
//		结果：编号（SPRING） - 编号（SUMMER）
		System.out.println(Season3.SPRING.compareTo(Season3.SUMMER));//-1
	}
}

enum Season3 {
	SPRING("春天", "温暖"),SUMMER("夏天", "酷热"),
	AUTUMN("秋天", "凉爽"),WINTER("冬天", "寒冷");
	private String name;
    private String desc;

	Season3(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}


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
