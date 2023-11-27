import java.util.*;

class OldAge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//病人总数
		//TODO 全部使用存取顺序一致的LinkHashMap
		LinkedHashMap<String, Integer> p = new LinkedHashMap<String, Integer>();
//输入
		for (int i = 0; i < n; i++) {
			p.put(in.next(), in.nextInt());
		}
		LinkedHashMap<String, Integer> old = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> young = new LinkedHashMap<String, Integer>();
		Set keySet = p.keySet();
		for (Object key : keySet) {
			if (p.get(key) > 60) {
				old.put((String) key, p.get(key));
			} else {
				young.put((String) key, p.get(key));
			}
		}

		LinkedHashMap<String, Integer> sortOld = (LinkedHashMap<String, Integer>) sortMap(old);
		Set keySetSorOld = sortOld.keySet();
		for (Object key : keySetSorOld) {
			System.out.println((String) key);
		}

		Set keySetYoung = young.keySet();
		for (Object key : keySetYoung) {
			System.out.println((String) key);
		}
	}

	public static Map<String, Integer> sortMap(Map<String, Integer> map) {
		//利用Map的entrySet方法，转化为list进行排序
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		//利用Collections的sort方法对list排序
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				//正序排列，倒序反过来
				return o2.getValue() - o1.getValue();
			}
		});
		//遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> e : entryList
		) {
			linkedHashMap.put(e.getKey(), e.getValue());
		}
		return linkedHashMap;
	}

}