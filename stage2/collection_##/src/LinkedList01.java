import java.util.LinkedList;

/**
 * @author qiaolezi
 * @version 1.0
 * LinkedList不保证线程安全
 * 操作时间复杂度：
 *  增：头增：O(1) 尾增：O(1) 指定位置 O(n)
 *  删：头删：O(1) 尾删：O(1) 指定位置 O(n)
 * 不能实现 RandomAccess接口（支持随机访问，通过索引快速访问元素），底层是双向链表
 */
public class LinkedList01 {
	public static void main(String[] args) {
		LinkedList<String> stringLinkedList = new LinkedList<>();
		stringLinkedList.add("1");
		stringLinkedList.add("2");
		stringLinkedList.add("3");
		stringLinkedList.forEach(System.out::println);

		Node node = new Node("1");
		Node node1 = new Node("2");
		Node node2 = new Node("3");

//		链接三个结点，形成双向链表
		node.next = node1;
		node1.next = node2;
		node2.pre = node1;
		node1.pre = node;

//		指定头尾
		Node first = node;//头
		Node last = node2;//尾

//		从头到尾
		while(true) {
			if(first == null) {
				break;
			}
			System.out.println(first);
			first = first.next;
		}
//		插入结点
		Node newNode = new Node("2.5");
		node1.next.pre = newNode;
		node1.next = newNode;
		newNode.pre = node1;
		newNode.next = node2;

//		从头到尾
		while(true) {
			if(last == null) {
				break;
			}
			System.out.println(last);
			last= last.pre;
		}
	}
}

//定义一个Node类，其对象表示 双向链表的一个结点
class Node {
	public Object item;//存放数据
	public Node pre;//指向上一个结点 <-
	public Node next;//指向下一个结点 ->
	public Node(Object name) {
		this.item = name;
	}

	@Override
	public String toString() {
		return "Node{" +
				"item=" + item +
				'}';
	}
}