/*
 对象变量是多态的，可以保存不同的变量（水果：苹果、香蕉...）
 可以保存声明类型的对象，或声明类型的子类的对象
 向上造型：将子类的对象赋给父类变量
 JAVA中不存在对象对对象的赋值  ||  父类的对象不可以赋值给子类变量
 Vehicle v;
 Car c = new Car();
 v = c;//OK
 c = v;//编译错误
 //造型
 c = Car(v);//只有当v实际管理的是Car才可以

JAVA中所有的类（toString\equals.etc）都继承自Object类
*/

import java.util.ArrayList;

public class Database
{
    private ArrayList<Item> listItem = new ArrayList<Item>();

    public void add(Item item)
    {
        listItem.add(item);
    }

    public void list()
    {
        // 唯一用到item的地方，这个item只要有一个print函数就行 
        for ( Item item : listItem )
        {
            // 动态绑定：item在运行中某个时刻管理的对象是什么就去相应的类中寻找print函数并执行
            item.print();
        }
    }


    public static void main(String[] args)
    {
        // 需要一个Item类型，给的是CD/DVD类型
        Database db1 = new Database();
        db1.add(new CD("abc", "abc", 4, 60, "..."));//abc:abc
        db1.add(new CD("def", "def", 4, 60, "..."));//def:def
        db1.add(new CD("ghi", "ghi", 4, 60, "..."));//ghi:ghi
        db1.list();

        Database db2 = new Database();
        db2.add(new DVD("qwe", "xxx",  60, "..."));
        db2.list();

         String s = "hello";
         s = "bye";//新建一个对象(ID=2)，内容是"bye"，s不再管理对象（ID=1）"hello"，而是管理"bye"

         Item item1 = new Item("aa", 3, false, "...");
//       CD cd1 = item1;//编译错误

         Item item2 = new Item("aa", 3, false, "...");
         CD cd2 = new CD("bb", "qwe", 3, 3, "...");
         //强制将item2转换为CD，但转换不合理，item2中实际存放的是Item类型
         // java.lang.ClassCastException: class Item cannot be cast to class CD (Item and CD are in unnamed module of loader 'app')
//         CD cd3 = (CD)item2;
         item2 = cd2;//OK
         CD cd4 = (CD)item2;//强制将item2转换为CD OK，转换合理，item2中实际存放的是CD类型
        // int i = (int)10.2;//强制转换


        // 父类的对象赋值给子类的变量 造型cast
        // item = cd; CD cc = (CD)item;//不会抛出异常，item中实际存放的是CD类型
        // CD cc = (CD)item;//class Item cannot be cast to class CD (Item and CD are in unnamed module of loader 'app')

        Object o = new Object();
    }
}
