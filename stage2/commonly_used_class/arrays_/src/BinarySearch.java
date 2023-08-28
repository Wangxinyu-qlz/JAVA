import java.util.Arrays;
import java.util.List;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class BinarySearch {
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 5, 7, 99, 100};
//		使用 binarySearch 二叉查找法
//		要求该数组有序（从大到小/从小到大），  否则不能使用
//		找到返回位置，从0开始
//		没找到返回  -(low + 1) low:应该存在的位置
		int index = Arrays.binarySearch(arr, 3);
		System.out.println(index);

//		数组元素复制
//		从arr数组中，复制arr.length个元素到 newArr 数组中
//		如果拷贝的长度 > arr.length 就在新数组后面 添加 null
//		如果复制长度 < 0，抛出异常NegativeArraySizeException
		Integer[] newArr = Arrays.copyOf(arr, arr.length + 1);
		System.out.println(Arrays.toString(newArr));//[1, 2, 5, 7, 99, 100, null]

//	    fill 数组填充
		Integer[] num = new Integer[]{1, 2, 3};
//		使用0填充num数组，替换所有元素
		Arrays.fill(num, 0);
		System.out.println("填充：");
		System.out.println(Arrays.toString(num));//[0, 0, 0]

//		比较两个数组的元素是否完全一致
		Integer[] arr2 = {1, 2, 5, 7, 99, 100};
		boolean equals = Arrays.equals(arr, arr2);
		System.out.println(equals);//true

//		转换为list
//		将(1, 2, 3, 5, 22, 0)数据转换为list集合
		List asList = Arrays.asList(1, 2, 3, 5, 22, 0);
		System.out.println("saList=" + asList);//saList=[1, 2, 3, 5, 22, 0]
		System.out.println(asList.getClass());//class java.util.Arrays$ArrayList
	}
}