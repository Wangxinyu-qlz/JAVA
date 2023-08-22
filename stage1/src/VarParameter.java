import org.jetbrains.annotations.NotNull;

public class VarParameter {
    public static void main(String[] args) {
        SumMethod sm = new SumMethod();
        System.out.println("求和结果为：" + sm.sum(1, 1, 1, 1));

        StuInfo si = new StuInfo();
        System.out.println(si.Info("王新宇", 1, 1, 1, 1, 1));
    }
}

 class SumMethod {
    //int... 表示接受可变参数，类型为int，数量为多个
    //可变参数可以作为数组使用
    //@@@@可变参数和普通参数同时存在时，可变参数必须放在最后
    //@@@@一个形参列表中最多只能有一个可变参数
    public int sum(int @NotNull ... nums) {
        System.out.println("接受的参数的个数为：" + nums.length);
        int res = 0;
        for(int i : nums){
            res += i;
        }
        return res;
    }
}

class StuInfo {
    public String Info(String name, @org.jetbrains.annotations.NotNull int @NotNull ...scores) {
        int tol = 0;
        for(int score : scores){
            tol += score;
        }
        return name + "同学" +scores.length + "门课程的总成绩为" + tol + "分";
    }
}
