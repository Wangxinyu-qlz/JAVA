/*
* HashCode将对象的内部地址转换为一个整数
* 但是HashCode不等价于地址
* 两个引用指向不同对象，HashCode一般不同
* 两个引用指向同一对象，HashCode一定相同
* 提高具有哈希结构的容器的效率
* 集合中的HashCode根据情况，也会重写
* */
public class HashCode {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a = a1;
        System.out.println("a1.hashCode:" + a1.hashCode());//668386784
        System.out.println("a2.hashCode:" + a2.hashCode());//793589513
        System.out.println("a.hashCode:" + a.hashCode());//668386784
    }
}
class A {

}
