package sort.overView;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 22:19
 * @description:
 **/
public class MergeS {
	public static void main(String[] args) {
		int[] test = {1, 2, 5, 2, 5, 8, 1, 245, 1, 0, -9, 523, 6, 21, 5, 21,};
		int n = test.length;
		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\n+++++++++++++++++++++++");

		merge(test, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
	}

	//public static
	public static void merge(int[] q, int l, int r){
		if(l >= r){
			return;
		}
		//以下定义在哪里无所谓
		int mid = (r + l) / 2;
		int[] res = new int[100];
		int i = l, j = mid+1, k=0;//TODO 注意这里的i j    k：已经排序的元素个数

		merge(q, l, mid);
		merge(q, mid+1, r);


		//处理完一个数组
		while(i<=mid && j<=r){
			if(q[i] <= q[j]) {
				res[k++]  =q[i++];
			} else{
				res[k++] = q[j++];
			}
		}
		//处理数组中剩下的元素
		if(i<=mid) {
			while(i <= mid) {
				res[k++] = q[i++];
			}
		}
		if(j <= r) {
			while(j<= r) {
				res[k++] = q[j++];
			}
		}

		//res[] => q[]
		for(int x=l, y = 0; x<=r; x++, y++){
			q[x]  =res[y];
		}
	}
}
