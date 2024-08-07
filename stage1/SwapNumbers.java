/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-07 16:18
 * @description:
 **/
public class SwapNumbers {
	public int a;
	public int b;

	//包装类交换
	public static void swap (Integer a, Integer b) {
		Integer temp = a;
		a = b;
		b = temp;
	}

	//直接交换
	public static void swap (int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	//数组
	public static void swap (int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}

	//成员对象
	public  void swapNum(int a, int b) {
		this.a = b;
		this.b = a;
	};

	//包装类打印
	public static void print(Integer m, Integer n) {
		System.out.println("m=" + m.intValue() + " n=" + n.intValue());
	}
	//直接打印
	public static void print(int a, int b) {
		System.out.println("a=" + a + " b=" + b);
	}
	//对象打印
	public  void print() {
		System.out.println("a=" + this.a + " b=" + this.b);
	}
	//数组打印
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {

		System.out.println("------直接交换----------");
		int a = 2, b = 3;

		print(a,b);
		swap(a, b);
		print(a,b);//2 3

		System.out.println("------包装类交换----------");
		Integer m = new Integer(2);
		Integer n = new Integer(3);

		print(m,n);
		swap(m, n);
		print(m,n);//2 3

		System.out.println("-------数组交换---------");
		int[] arr = {2,3};
		print(arr);
		swap(arr);
		print(arr);//3 2

		System.out.println("-------成员变量交换---------");
		print(a,b);
		SwapNumbers sn = new SwapNumbers();
		sn.swapNum(a, b);
		sn.print();//3 2

	}
}
