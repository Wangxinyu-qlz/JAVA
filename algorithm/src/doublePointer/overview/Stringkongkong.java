package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 09:23
 * @description:
 **/
public class Stringkongkong {
	public static void main(String[] args) {
		String s = "hello world";
		int n = s.length();
		for(int i=0; i<n; i++) {
			int j = i;
			while(j<n && ' ' != s.charAt(j)) {
				j++;
			}
			for(int k=i; k<j; k++) {
				System.out.print(s.charAt(k));
			}
			System.out.println();
			i = j;
		}
	}
}
