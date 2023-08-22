public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
//        ==在这里判断的是地址（空间是否相同）
        System.out.println(a == b);//true
        System.out.println(a == c);//true
        B bObj = a;
        B bObj_ = new A();//与上等价，向上转型
        System.out.println(a == bObj);//@@@true@@@
//        ==还可以判断基本数据类型的值是否相等
        int aa = 10;
        int bb = 10;
        System.out.println(aa == bb);//true
//        equals方法：只能判断引用类型是否相等
//        但其子类往往重写该方法，用于判断内容是否相同。如：Integer,String
        System.out.println("Hello".equals("hello"));//false
        System.out.println("A".equals("A"));//true
//        Object类的equals：
//        public boolean equals(Object obj) {
//        return (this == obj);
//        String类的equals：
//        public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//        return (anObject instanceof String aString)
//                && (!COMPACT_STRINGS || this.coder == aString.coder)
//                && StringLatin1.equals(value, aString.value);
//        }
//        Integer integer1 = new Integer(1000);//Deprecated
        String string1 = new String("a");
        String string2 = new String("a");
        System.out.println(string1 == string2);//false
        System.out.println(string1.equals(string2));//true
    }
}
class A extends B{

}

class B {

}
