package linkedNode;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-30 09:41
 * @description:
 **/
public class DeleteNode {
	public static void main(String[] args) {
		Node node3 = new Node(3, null);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		Node q = node1;
		while (q != null) {
			System.out.print(q.val + " ");
			q = q.next;
		}
		System.out.println();

		//q = node1;
		//while (q.next != null) {
		//	q = q.next;
		//}
		//int m = 3;
		//Scanner in = new Scanner(System.in);
		//while (m-- > 0) {
		//	Node tmp = new Node(in.nextInt(), null);
		//	q.next = tmp;
		//	q = tmp;
		//}
		//
		//System.out.println("最后一个节点的值是：" + q.val);
		//
		//System.out.println("遍历整个链表：");
		//q = node1;
		//while (q != null) {
		//	System.out.print(q.val + " ");
		//	q = q.next;
		//}

	//	根据值找到结点在后面添加
		int target = 2;
		q = node1;
		while(q.val != target) {
			q = q.next;
		}

		Node tmp1 = new Node(0, null);
		tmp1.next = q.next;
		q.next = tmp1;

		q = node1;
		while(q != null) {
			System.out.print(q.val + " ");
			q = q.next;
		}
	}
}


class Node {
	int val;
	Node next;

	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}
