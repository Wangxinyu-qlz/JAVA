public class practice01 {
    public static void main(String[] args){
        int totalDays = 59;
        int weeks = totalDays / 7;
        int days = totalDays % 7;
        System.out.println(totalDays + "天是" + weeks + "周零" + days + "天");

        float huashi = 234.5f;
        float sheshi = (float)(5.0 / 9 * (huashi - 100));
        System.out.println("摄氏温度为:" + sheshi);

        int a = 1;
        int b = 21;
//      第一个条件为false，第二个条件不会执行
        if( a < 0 && ++b < 50 ){
        }
        System.out.println("a=" + a + "\tb=" + b);//1 21
//      第一个条件为false，第二个条件仍然执行
        if( a < 0 & ++b < 50 ){
        }
        System.out.println("a=" + a + "\tb=" + b);//1 22

        int c = 32;
        int d = 54;
//      第一个条件为true，第二个条件不会执行
        if( c == 32 || ++d < 100 ){
        }
        System.out.println("c=" + c + "\td=" + d);//32 54
//      第一个条件为true，第二个条件仍然执行
        if( c == 32 | ++d < 100 ){
        }
        System.out.println("c=" + c + "\td=" + d);//32 55

//      逻辑异或 a^b：a b不同时结果为true，相同时结果为false
        boolean e = (-1 < 0) ^ (0 < 1);
        System.out.println(e);//false
        boolean f = (-1 < 0) ^ (0 > 1);
        System.out.println(f);//true

        int aa = 20;
        int bb = 15;
        int result = aa > bb ? 1 : 0;
        System.out.println(result);

        System.out.println("位运算符：");
//      原码->补码->按位运算->原码
        /*
        * 1的原码：00000000 00000000 00000000 00000001
        * 1的补码：00000000 00000000 00000000 00000001
        * 2的原码：00000000 00000000 00000000 00000010
        * 2的补码：00000000 00000000 00000000 00000010
        * 将 补码 按位与 &：
        * 00000000 00000000 00000000 00000001
        * 00000000 00000000 00000000 00000010
        * 00000000 00000000 00000000 00000000 -> 原码为：
        * 00000000 00000000 00000000 00000000 -> 0
        * */
        System.out.println(1 & 2);
        System.out.println(1 | 2);//3(011)    01 | 010 两位有一个为1结果为1，否则为0
        /*
        * -2的原码：10000000 00000000 00000000 00000010
        * -2的反码：11111111 11111111 11111111 11111101 (符号位不变，其他位取反)
        * -2的补码：11111111 11111111 11111111 11111110 (反码 + 1)
        * 按位取反：00000000 00000000 00000000 00000001 ->原码为：
        * 00000000 00000000 00000000 00000001 -> 1
        * */
        System.out.println(~-2);//1
//      算数右移：低位溢出，符号位不变，用符号位补溢出的高位
        System.out.println(1>>2);//00000001 -> 00000000 本质：1 / 2 / 2 = 0
//      算数左移：符号位不变，低位补0
        System.out.println(1<<2);//00000001 -> 00000100 本质：1 * 2 * 2 = 4
//      逻辑右移：低位溢出，高位补0
        System.out.println(1>>>2);//0

        int as = 'a';
        System.out.println(as);//97

//        double asd = 1.1;
//        switch(asd){//不兼容的类型。实际为 double'，需要 'char、byte、short、int、Character、Byte、Short、Integer、String 或枚举'
//            case 1.1: System.out.println("1.1");
//        }

        System.out.println("九九乘法表：");
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.print("\n");
        }

        int cengshu = 5;
        for(int i = 1, count = 0; i <= cengshu; i++){
            for(int k = 1; k <= cengshu - i; k++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++){
                if(j == 2 * i - 1 || j == 1 || i == cengshu) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

        int ii = 1;
//        死循环 当i=2时，在if中跳出循环，进行下一次循环，但i并没有+1，在if处跳出循环并进行下一次循环...
//        while( ii < 5) {
//            if( ii == 2){
//                continue;
//            }
//            System.out.print(ii + "\t");//1 死循环
//            ii++;
//        }
        while( ii < 5) {
            ii++;
            if( ii == 2){
                continue;
            }
            System.out.print(ii + "\t");//345
        }

    }
}
