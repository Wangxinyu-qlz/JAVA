public class TowerOfHanoi {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(25, 'A', 'B', 'C');
    }
}
class Tower {
    //num:要以移动的个数 a:A塔 b:B塔 c:C塔
    public void move(int num, char a, char b, char c) {
        if(num == 1) {//如果有1个盘
            System.out.println(a + "->" + c);
        } else {//如果有多个盘，可以看做：最下面的和上面的所有盘
            //将上面所有的盘，移动到B塔，借助C塔
            move(num-1, a, c, b);
            //将最下面的盘移动到C塔
            System.out.println(a + "->" + c);
            //将B塔的所有盘，移动到C塔，借助A塔
            move(num - 1, b, c, a);
        }
    }
}
