/**
 * 先搭建框架，写好需要的接口名称和返回的类型
 * 再逐步完善
 */
import java.util.ArrayList;
import java.util.HashSet;

class Value
{
    private int i;
    public void set(int i)
    {
        this.i = i;
    }
    public int get()
    {
        return i;
    }
    // 添加此函数可以直接输出这个类的对象(容器中的内容)  System.out.println(c);//10  l-104
    public String toString()
    {
        return ""+i;
    }
}

public class NoteBook
{
    // 泛型类  是一种容器  容器的类型<元素的类型>
    // 变量 notes 是一个对象管理者，它的类型是用来存放 String 的ArrayList
    // ArrayList中的元素是有顺序的，下标从0开始
    private ArrayList<String> notes = new ArrayList<String>();

    // 在末尾添加
    public void add(String s)
    {
        notes.add(s);
        // notes.add(10);//ERROR只能接收String，int不行
    }

    // 在任意位置添加
    public void add(String s, int location)
    {
        notes.add(location, s);
    }

    public int getSize()
    {
        return notes.size();
    }

    public String getNote(int index)
    {
        return "test";
    }

    //判断有没有删除成功
    public void removeNote(int index)
    {
        notes.remove(index);
    }

    public String[] list()
    {
        // 数组的长度是notes的长度
        String[] a = new String[notes.size()];
        // for ( int i=0; i<notes.size(); i++ )
        // {
        //     a[i] = notes.get(i);
        // }
        // 尽量用系统类库
        // 填充都数组a
        notes.toArray(a);
        return a;
    }


    public static void main(String[] args)
    {
        // ArrayList<String> a = new ArrayList<String>();
        // a.add("frist");
        // a.add("second");
        // a.add("first");
        // for ( String s : a )
        // {
        //     System.out.println(s);//first second  frist
        // }
        // System.out.println(a);//[frist, second, first]

        // System.out.println("------------");

        // // 重复的元素不会添加
        // HashSet<String> s = new HashSet<String>();
        // s.add("first");
        // s.add("second");
        // s.add("first");
        // for ( String k : s )
        // {
        //     System.out.println(k);//first second
        // }
        // System.out.println(s);//[first, second]

// 数组的for-each循环
        int[] d = new int[10];
        for ( int i = 0; i<d.length; i++ ){
            d[i] = i;
        }
        for ( int k : d ){
            // 循环的每一轮中的k是这个元素的复制品
            k++;//不起作用
        }
        for ( int k : d ){
            System.out.println(k);//0123456789
        }
// 对象数组的for-each循环
        // Value c = new Value();
        // c.set(10);
        // System.out.println(c);//10

        // Value[] a = new Value[10];
        // // 初试化
        // for ( int i=0; i<a.length; i++ )
        // {
        //     a[i] = new Value();
        //     a[i].set(i);
        // }
        // // v在遍历中依次指向a[i]所指的对象，即两者共同管理对象，v.set(0)改变了对象的值
        // // foreach循环可以更改对象数组中的对象的值
        // for ( Value v : a )
        // {
        //     System.out.println(v.get());//0123456789
        //     v.set(0);
        // }
        // for ( Value v : a )
        // {
        //     System.out.println(v.get());//0000000000
        // }

        // String[] a = new String[2];
        // a[0] = "first";
        // a[1] = "second";
        // NoteBook nb = new NoteBook();
        // nb.add("first");
        // nb.add("second");
        // nb.add("third", 1);//插入
        // System.out.println(nb.getSize());//3
        // System.out.println(nb.getNote(0));//test
        // System.out.println(nb.getNote(10));//test  下标越界  没有抛出异常
        // System.out.println(a[2]);//下标越界抛出异常Index 2 out of bounds for length 2

        // nb.removeNote(1);
        // String[] b = nb.list();
        // for ( String s : b )
        // {
        //     System.out.println(s);
        // }
        /*
         * first
         * second
         */



// 对象管理者  
        // int[] is = new int[10];
        // String[] s = new String[10];//做了10个格子，每个格子中都是对象管理者，但是他们现在还没有管理任何人
        // // 初始化
        // // for ( int i=0; i<s.length; i++ )
        // // {
        // //     s[i] = ""+i;
        // // }
        // System.out.println(is[0]+2);//0  # 2  # 2
        // System.out.println(s[0]+"a");//null  # nulla   # 0a
        // System.out.println(s.length);//10
        // System.out.println(s[0].length());//初始化之后：1
        // System.out.println(s[0]);//0
        // //不进行初始化：Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "s[0]" is null
        // // System.out.println(s[0].length());

        // String str = null;
        // //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
        // // System.out.println(str.length());
    }
}
