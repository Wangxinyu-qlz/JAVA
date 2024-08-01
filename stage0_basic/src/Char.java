package src;

import java.util.Scanner;

public class Char 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        char c = 'a';
        char d = 'A';
        System.out.println(c);//a
        c++;
        System.out.println(c);//b
        System.out.println((int)c+" "+(int)d);//98 65
        System.out.println(c-d);//33

        char h = '1';
        h++;
        System.out.println(h);//丁
    }
}
