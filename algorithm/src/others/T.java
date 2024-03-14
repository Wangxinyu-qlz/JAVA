package others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class T {
	public static void main(String[] args){
		//int[][] a = new int[3][2];
		int[][] a = {{1,3},{2,2},{3,1}};
		System.out.println(maximumUnits(a, 4));

	}
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int[][] newBoxTypes = mySort(boxTypes);
        int numsBox = 0;
        int numsUnit = 0;
        for(int i=0; i<newBoxTypes.length; i++){
            for(int j = 0; j < newBoxTypes[i][0]; j++){
                numsUnit = numsUnit + newBoxTypes[i][1];
                numsBox += 1;
                if(numsBox == truckSize){
                    return numsUnit;
                }
            }
        }
        return 0;
    }

    public static int[][] mySort(int[][] array){
        // 新建一个比较器Comparator作为匿名内部类
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    // 比较它们的第二个元素
                    return o2[1] - o1[1];
            }
        });
        return array;
    }
}
