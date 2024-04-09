package string;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-08 16:48
 * @description:
 * 如果您的字符串 S 包含一个重复的子字符串，那么这意味着您可以多次 “移位和换行”`您的字符串，并使其与原始字符串匹配。
 * 例如：abcabc
 * 移位一次：cabcab
 * 移位两次：bcabca
 * 移位三次：abcabc
 * 现在字符串和原字符串匹配了，所以可以得出结论存在重复的子串。
 * 基于这个思想，可以每次移动k个字符，直到匹配移动 length - 1 次。但是这样对于重复字符串很长的字符串，效率会非常低。在 LeetCode 中执行时间超时了。
 * 为了避免这种无用的环绕，可以创建一个新的字符串 str，它等于原来的字符串 S 再加上 S 自身，这样其实就包含了所有移动的字符串。
 * 比如字符串：S = acd，那么 str = S + S = acdacd
 * acd 移动的可能：dac、cda。其实都包含在了 str 中了。就像一个滑动窗口
 * 一开始 acd (acd) ，移动一次 ac(dac)d，移动两次 a(cda)cd。循环结束
 * 所以可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
 * 作者：Goodlucky
 * 链接：https://leetcode.cn/problems/repeated-substring-pattern/solutions/114572/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		String s = "abcabc";
		System.out.println(repeatedSubstringPattern(s));
	}
	public static boolean repeatedSubstringPattern(String s) {
		return (s+s).substring(1, 2*s.length() - 1).contains(s);
	}
}
