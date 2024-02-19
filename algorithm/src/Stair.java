public class Stair {
	public static void main(String[] args){
		int i= 1;
		int j = 2;
		int total = 11;
		int sum = 0;
		for(int k = 3; k<=total; k++){
			sum = i + j;
			i = j;
			j = sum;
		}
		System.out.println(sum);

	}
}
