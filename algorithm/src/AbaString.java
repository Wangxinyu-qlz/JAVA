/**
 * @author qiaolezi
 * @version 1.0
 */
public class AbaString {
	public static void main(String[] args){
		String s = "aaaac";
		int n = longestPalindrome(s);
		System.out.println(n);
	}
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;//'a'-->97
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
