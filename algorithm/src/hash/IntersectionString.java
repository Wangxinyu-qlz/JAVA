package hash;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-06 15:51
 * @description:
 **/
public class IntersectionString {
	public static void main(String[] args) {
		String a = "qwe";
		String b = "ewq";
		String c = "wer";
		System.out.println(intersection(a, c));
	}

	public static boolean intersection(String a, String b) {
		int[] inter = new int[26];
		for(int i=0; i<a.length(); i++){
			inter[a.charAt(i) - 'a'] ++;
		}
		for(int i=0; i<b.length(); i++) {
			inter[b.charAt(i) - 'a']--;
		}
		for(int i=0; i<26; i++) {
			if(inter[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
