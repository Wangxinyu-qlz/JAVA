import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int day = in.nextInt();
		long sum = 0;
		for (int i = 1; i <=day; i++) {//t组测试
			sum+= i;
		}
		System.out.println(sum);
		System.out.print((int)(sum/day));

	}

}