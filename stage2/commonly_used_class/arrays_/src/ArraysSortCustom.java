import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ArraysSortCustom {
	public static void main(String[] args) {
		int[] arr = {1, 1, 5, 4, 9, -9, 3};
//		bubble01(arr);
		bubble02(arr, new Comparator() {
			@Override
			//将bubble内部的for循环的(arr[j],arr[j + 1])===(Object o1,Object o2)
			public int compare(Object o1, Object o2) {
				int i1 = (Integer) o1;
				int i2 = (Integer) o2;
				return i1 - i2;
			}
		});
		System.out.println(Arrays.toString(arr));

	}

	public static void bubble01(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {//从大到小
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1]  =temp;
				}
			}
		}
	}

	public static void bubble02(int[] arr, Comparator c) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (c.compare(arr[j], arr[j + 1]) > 0) {//从大到小
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1]  =temp;
				}
			}
		}
	}
}

