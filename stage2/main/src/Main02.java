/*
* 配置 运行配置 在program argument中填入参数：beijing 伤害 jack
* 运行结果如下：
* args[0]=beijing
* args[1]=伤害
* args[2]=jack
* */
public class Main02 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]=" + args[i]);
        }
    }
}
