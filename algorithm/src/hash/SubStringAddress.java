package hash;

import java.util.*;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-07-17 08:22
 * @description:
 **/
public class SubStringAddress {
	public static void main(String[] args) {
		String s = "ababababab";
		String p = "aab";
		Map<Character, Integer> set = new HashMap<>();
		List<Integer> re = new ArrayList<Integer>();

		int sl = s.length();
		int pl = p.length();

		int n = 0;
		// 将所有的子串字母放进set，方便查找
		for (int i = 0; i < pl; i++) {
			Integer integer = set.get(p.charAt(i));
			if (integer == null) {
				set.put(p.charAt(i), 1);
			} else {
				set.put(p.charAt(i), integer + 1);
			}
		}
		int size = 0;
		Collection<Integer> values = set.values();
		for(Integer v:values) {
			size += v;
		}
		int index = -1;
		// 遍历母串
		for (int i = 0; i + size <= sl; i++) {
			//依次查看字母是否在set中，不在的话，就右移一位
			if (!set.containsKey(s.charAt(i))) {
				continue;
			}
			//如果在，记录当前的索引，就判断后面的set.size() - 1个字母在不在
			// 需要判断的是：是不是所有的字母都在，并且一一对应
			index = i;
			boolean flag = true;
			HashMap<Character, Integer> s_set = new HashMap<Character, Integer>();
			for (int j = i; j < i + size; j++) {
				//将母串中的字母记录下来
				Integer integer = s_set.get(s.charAt(j));
				if (integer == null) {
					s_set.put(s.charAt(j), 1);
				} else {
					s_set.put(s.charAt(j), integer + 1);
				}

				// 如果不在子串中，直接终止
				if (!set.containsKey(s.charAt(j))) {
					flag = false;
					break;
				}
			}
			//判断子串字母是否都在母串中
			for (Map.Entry<Character, Integer> entry : set.entrySet()) {
				Character key = entry.getKey();
				if (!s_set.containsKey(key)) {
					flag = false;
					break;
				}
			}
			//如果子串 和 母串当前的滑动窗口中的字母互相包含，就将这个索引放入re结果列表
			if (flag) {
				re.add(index);
			}
			// 清空两个set
			// set.clear();
			s_set.clear();
		}
		System.out.println(re);
	}
}
