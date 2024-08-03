package qlz;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Byte Short Integer Long包装类的缓存区间: [-128, 127]
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);//true

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);//false

        //Character包装类缓存区间:[0, 127]
        Character ci = 0;
        Character cj = 0;
        System.out.println(ci == cj);//true

        Character ca = 128;
        Character cb = 128;
        System.out.println(ca == cb);//false
    }
}
