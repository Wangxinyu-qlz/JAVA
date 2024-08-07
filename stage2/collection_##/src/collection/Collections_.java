package collection;

import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Collections_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("tom");
		list.add("king");
		list.add("milan");
		list.add("tay");
		list.add("joy");

		System.out.println(list);//[tom, king, milan, tay, joy]

//		反转 list 中的元素顺序
		Collections.reverse(list);
		System.out.println(list);//[joy, tay, milan, king, tom]

//		对 list 中的元素进行随机排序，每次执行都不一样
		Collections.shuffle(list);
		System.out.println(list);//[king, tom, joy, tay, milan]

//		根据元素的自然顺序，对 list 中的元素进行排序（首字母）
		Collections.sort(list);
		System.out.println("自然排序" + list);

//		指定规则排序
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
//				可以加入一些校验
				return ((String)o1).length() - ((String)o2).length();
			}
		});
		System.out.println("长度排序" + list);//长度排序[joy, tay, tom, king, milan]

//	    交换
		Collections.swap(list, 0, 1);
		System.out.println("交换" + list);//交换[tay, joy, tom, king, milan]

//		最大值，自然顺序
		System.out.println(Collections.max(list));//tom
//		最大值，自定义规则
		System.out.println(Collections.max(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((String)o1).length() - ((String)o2).length();
			}
		}));//milan

//		最小值，自然顺序
		System.out.println(Collections.min(list));//joy
//		最小值，自定义
		System.out.println(Collections.min(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((String)o1).length() - ((String)o2).length();
			}
		}));//tay

		System.out.println("tom出现的次数：" + Collections.frequency(list, "tom"));//1

//		list拷贝
//		TODO 为了完成拷贝，要保证目的list的长度 >= 源list
		ArrayList dest = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			dest.add("");
		}
		Collections.copy(dest, list);
		System.out.println("dest=" + dest);

//		替换
//		如果list中有 "tom"，替换为 "汤姆"
		Collections.replaceAll(list, "tom", "汤姆");
		System.out.println(list);//[tay, joy, 汤姆, king, milan]
	}
}
