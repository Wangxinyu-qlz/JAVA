        // System.out.println("欢迎！\n请输入商品名：");
        // Scanner in1 = new Scanner(System.in);
        // String str = in1.next();
        // System.out.println("商品：" +str);

        // System.out.println("价格：");
        // Scanner in0 = new Scanner(System.in);
        // int number = in0.nextInt();
        // System.out.println("价格为：" + number);
        // System.out.println("找零：" + (100-number));
        // int price = 100;
        // System.out.printf("找零：%d-%d\n", price, (100-number));

        // System.out.println(2+3 + "=2+3=" + (2+3));//括号运算符

        // Scanner in2 = new Scanner(System.in);
        // int inch;
        // int foot;
        // foot = in2.nextInt();
        // inch = in2.nextInt();
        // System.out.println((foot + inch / 12) * 0.3048);//0.9144000000000001  False
        // System.out.println((int)((foot + inch / 12.0) * 0.3048 * 100));//0.9398000000000001  True

        // double a = 1.0;
        // double b = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        // System.out.println(a == b);//False

        // // if中卫True或False，不接受其他类型
        // if((Math.abs(a - b)) < (1e-7))
        // {
        //     System.out.println("a==b");//True
        // }
        
        // int type = in2.nextInt();
        // switch( type )
        // {
        //     case 1:
        //     System.out.println("你好！");
        //     break;
        //     case 2:
        //     System.out.println("Hello!");
        //     break;
        //     default:
        //     System.out.println("泥嚎!");
        //     break;
        // }

        // int count = in2.nextInt();
        // while(count > 0)
        // {
        //     System.out.println("循环：" + count);
        //     count --;
        // }

        // int n = in2.nextInt();
        // do{
        //     System.out.println(n);
        //     n--;
        // }while(n > 0);

        // for(int i = 0; i < 3; i++)
        // {
        //     System.out.printf("%d\n\n", i);
        // }

        // int j = 0;
        // int x = j++;
        // int k = 0;
        // int y = ++k;
        // System.out.println("j=0,k=0" + ";x=j++=" + 0 + ";y=++k=" + 1);

        // OUT:
        // for(int i = 0; i < 2; i++)
        // {
        //     for( int c = 0; c < 2; c++)
        //     {
        //         if(c == 1)
        //         {
        //             System.out.println("i=" + i + ";c=" + c);//i=0;c=1
        //             break OUT;//跳出到标识符OUT的地方
        //             // break;//跳出当前所在的for
        //         }
        //     }
        // }

        // if(4 < 5 && 4 > 3)
        // {
        //     System.out.println("3<4<5");
        // }

        // System.out.println("请输入正整数：");
        // int [] array = new int[100];
        // for (int a1 = 0; a1 < array.length; a1++)
        // {
        //     int ele = in2.nextInt();
        //     if(ele != 0)
        //     {
        //         array[a1] =ele;
        //     } 
        //     else
        //     {
        //         System.out.println("已经结束啦！");
        //         break;
        //     }
        // }
        // for(int a2 = 0; a2<100&&array[a2]!=0; a2++)
        // {
        //     System.out.println(array[a2]);
        // }

        // int [] a1 = new int[5];
        // int [] b1 = new int[5];
        // a1[0] = 5;
        // b1[0] = 6;
        // System.out.println("a1[0]=" + a1[0] + " b1[0]=" + b1[0]);
        // // #########################################################################################
        // int [] c1 = a1;//c1和a1共同管理了同一个数组
        // c1[0] = 0;
        // System.out.println("a1[0]=" + a1[0] + " b1[0]=" + b1[0] + " c1[0]=" + c1[0]);

        // int [] d1 = {1, 2, 3, 4, 5};
        // int [] e1 = new int[d1.length];
        // for(int q = 0; q < d1.length; q++)
        // {
        //     e1[q] = d1[q];
        // }
        // for(int r = 0; r < e1.length; r++)
        // {
        //     System.out.printf("%d  ", e1[r]);
        // }

        // System.out.println("请输入您要查找的数字：");
        // int index = in2.nextInt();
        // for(int z : e1)//for each循环，z是数组e1中的元素，但是无法识别在数组中的位置，也能通过k修改数组中元素的值
        // {
        //     System.out.println(z);
        //     if( z == index)
        //     {
        //         System.out.println("找到了！" + z);
        //     }
        // }

        // System.out.println("####################");
        // int [][] a3 = new int[3][4];
        // int [][] b3 = {
        //     {1},
        //     {1, 2},
        // };
        // System.out.println("b3.length:" + b3.length);
        // for ( int i=0; i < b3.length; i++)
        // {
        //     for ( int f=0; f < b3[i].length; f++)
        //     {
        //         System.out.println(b3[i][f]);
        //     }
        // }