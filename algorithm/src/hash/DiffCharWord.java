package hash;


import java.util.*;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-07-12 22:22
 * @description: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 遍历字符串数组strs中的每个字符串str；
 * 将字符串str转换为字符数组array并进行排序；
 * 将排序后的字符数组array转换为字符串key；
 * 通过map.getOrDefault(key, new ArrayList<String>())获取键为key的值列表list，如果不存在则创建一个新的ArrayList；
 * 将原始字符串str添加到列表list中；
 * 将更新后的列表list通过map.put(key, list)放回map中；
 * 最后，将map中的所有值转换为ArrayList存储在lists中。
 **/
public class DiffCharWord {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String key = new String(array);//将排好序的字符串作为key
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			map.put(key, list);
		}
		ArrayList<List<String>> lists = new ArrayList<List<String>>(map.values());
		System.out.println(lists);
	}
}
