package Coin.src;

import java.util.HashMap;
import java.util.Scanner;


public class Coin
{

    // 泛型类
    private HashMap<Integer, String> coinname = new HashMap<Integer, String>();

    public Coin()
    {
        coinname.put(1, "penny");
        coinname.put(10, "diem");
        coinname.put(25, "quarter");
        coinname.put(50, "half-dolar");
        coinname.put(50, "5角");
        System.out.println("主键的数量为：" + coinname.keySet().size());//4
        System.out.println("键值对为：" + coinname);//{1=penny, 50=5毛, 25=quarter, 10=diem} 之前的值会被覆盖

        // penny 5毛 quarter diem
        // 列出来key的集合，去取集合中的元素
        // for ( Integer k: coinname.keySet() )
        // {
        //     String s = coinname.get(k);
        //     System.out.println(s);
        // }
    }

    public String getName(int amount)
    {
        // switch case 可以实现但是不够优雅
        // switch( amount )
        // {
        //     case 10: return "dime";
        // }

        if ( coinname.containsKey(amount) )
            return coinname.get(amount);
        else
            return "NOT FOUND";
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("echo:");
        int amount = in.nextInt();
        Coin coin = new Coin();
        String name = coin.getName(amount);
        System.out.println("键" + amount + "对应的值为：" + name);
        in.close();

    }
}