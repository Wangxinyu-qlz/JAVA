/**
 * @author qiaolezi
 * @version 1.0
 */
public class LinkedList01 {
	public static void main(String[] args) {
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
	public Node pre;//指向上一个结点
	public Node next;//指向下一个结点
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