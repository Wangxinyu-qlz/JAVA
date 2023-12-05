import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[][] e = new int[t][3];
		char[] s = new char[t];
		for(int i=0; i<t; i++){
			e[i][0] = in.nextInt();
			s[i] = in.next().charAt(0);
			e[i][1] = in.nextInt();
			char temp = in.next().charAt(0);
			e[i][2] = in.nextInt();
		}

		for(int i=0; i<t; i++){

			if(s[i]=='-'){
				if(e[i][0] - e[i][1] == e[i][2]){
					System.out.println(1);
				}
			}

			if(s[i]=='+'){
				if(e[i][0] + e[i][1] == e[i][2]){
					System.out.println(1);
				}
			}

		}

	}
}