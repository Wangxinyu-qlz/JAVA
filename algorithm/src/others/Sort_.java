package others;

import java.util.*;
public class Sort_ {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0; i<n; i++){
			array[i] = in.nextInt();
		}
		Arrays.sort(array);
		for (int i:array){
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
