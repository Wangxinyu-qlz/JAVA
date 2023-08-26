/**
 * @author qiaolezi
 * @version 1.0
 * 自定义枚举类实现
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

//演示自定义枚举实现
class Season {
    private String name;
    private String desc;

    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");

//    1.将构造器私有化，放置new
//    2.去掉set相关方法，保留get方法，放置属性被修改，只能读取
//    3.在Season类内部，创建固定的对象
//    4.优化：接入 final 修饰符，TODO 常量使用大写
    private Season(String name, String desc) {
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
