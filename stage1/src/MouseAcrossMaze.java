public class MouseAcrossMaze {
    public static void main(String[] args){
//      创建迷宫maze
        int[][] map = new int[8][7];
        for(int j = 0; j < map[0].length ;j++){
            map[0][j] = 1;
            map[7][j] = 1;
        }
        for(int i = 0; i < map.length ;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;
        map[2][1] = 1;
        System.out.println("maze:");
//      打印迷宫
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }
//      使用findWay寻路
        T t1 = new T();
        t1.findWay(map, 1, 1);
        System.out.println("路径:");
//      打印路径
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }

    }
}
class T {
    /*
    * 使用递归回溯解决老鼠出迷宫
    * findWay方法寻找路径
    * return:找到true，否则false
    * map为路径，i j为老鼠位置，初始化为(1,1)
    * 0:可以走 1:障碍物 2:可以走 3:走过但是死路
    * 当(6,5)为2时，找到通路->结束，否则继续找
    * 先确定寻路策略：下->右->上->左
    * */
    public boolean findWay(int[][] map, int i, int j){
        if(map[6][5] == 2){//说明已经找到->结束
            return true;
        } else{
            if(map[i][j] == 0){//当前位置为0，说明可以走
                //假设可以走
                map[i][j] = 2;
                //使用找路策略，确该位置是否可以走通
                if(findWay(map, i + 1, j)){//先走下
                    return true;
                } else if(findWay(map, i, j + 1)){//右
                    return true;
                } else if(findWay(map, i - 1, j)){//上
                    return true;
                } else if(findWay(map, i, j - 1)){//左
                    return true;
                } else{
                    map[i][j] = 3;
                    return false;
                }
            } else{//map[i][j] == 1(障碍物不走), 2(找过不走), 3(死路不走)
                return false;
            }
        }
    }
}
