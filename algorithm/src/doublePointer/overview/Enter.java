package doublePointer.overview;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 11:53
 * @description:
 **/
public class Enter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		int n = s.length();
		for(int i=0; i<n; i++) {
			int j = i;
			while(j<n && s.charAt(j) != ' ') {
				j++;
			}
			for(int k = i; k<j; k++) {
				System.out.print(s.charAt(k));
			}
			System.out.println();
			i = j;
		}

	}
}
