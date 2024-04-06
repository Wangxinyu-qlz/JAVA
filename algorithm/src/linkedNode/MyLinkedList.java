package linkedNode;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-05 16:21
 * @description: * Your MyLinkedList object will be instantiated and called as such:
 * * MyLinkedList obj = new MyLinkedList();
 * * int param_1 = obj.get(index);
 * * obj.addAtHead(val);
 * * obj.addAtTail(val);
 * * obj.addAtIndex(index,val);
 * * obj.deleteAtIndex(index)
 **/
class MyLinkedList {
	int size;
	ListNode head;

	public MyLinkedList() {
		size = 0;
		head = new ListNode(0);
	}

	public int get(int index) {
		if (index < 0 || index >= size) return -1;
		ListNode cur = head;
		for (int i = 0; i <= index; i++) {
			cur = cur.next;
		}
		return cur.val;
	}

	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	public void addAtTail(int val) {
		addAtIndex(size, val);
	}

	public void addAtIndex(int index, int val) {
		if (index > size) return;

		index = Math.max(0, index);
		size++;
		ListNode pred = head;
		for (int i = 0; i < index; i++) {
			pred = pred.next;
		}

		ListNode toAdd = new ListNode(val);
		toAdd.next = pred.next;
		pred.next = toAdd;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) {
			return;
		}

		size--;
		ListNode pred = head;
		for (int i = 0; i < index; i++) {
			pred = pred.next;
		}
		pred.next = pred.next.next;
	}

	public static ListNode reverse(MyLinkedList l) {
		ListNode tmp;
		ListNode cur = l.head.next;
		ListNode pre = null;

		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	public static ListNode reversePair(MyLinkedList l) {
		ListNode cur = l.head;
		while (cur.next != null && cur.next.next != null) {
			ListNode tmp = cur.next;
			ListNode tmp1 = cur.next.next.next;

			cur.next = cur.next.next;
			cur.next.next = tmp;
			cur.next.next.next = tmp1;

			cur = cur.next.next;
		}
		return l.head.next;
	}

	public static void deleteNthFromEnd(MyLinkedList l, int n) {
		ListNode fast = l.head;
		ListNode slow = l.head;
		while(fast != null && n-- > 0) {
			fast = fast.next;
		}
		fast = fast.next;  //再走一步
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
	}

	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		System.out.println(l.get(0));//-1
		l.addAtHead(1);
		System.out.println(l.get(0));//1
		l.addAtIndex(1, 2);
		l.addAtTail(3);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		l.deleteAtIndex(2);
		l.addAtTail(4);
		l.addAtTail(5);
		l.addAtTail(6);
		l.addAtTail(7);
		l.addAtTail(8);
		System.out.println("遍历--------------------");
		for (int i = 0; i < l.size; i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println();

		//System.out.println("翻转----------------------");
		//ListNode reverseHead = reverse(l);
		//while (reverseHead != null) {
		//	System.out.print(reverseHead.val + " ");
		//	reverseHead = reverseHead.next;
		//}
		//System.out.println();

		System.out.println("两两翻转---------------------");

		ListNode reversePairHead = reversePair(l);
		while (reversePairHead != null) {
			System.out.print(reversePairHead.val + " ");
			reversePairHead = reversePairHead.next;
		}
		System.out.println();

		System.out.println("删除倒数第n个结点------------");
		deleteNthFromEnd(l, 2);
		ListNode cur = l.head.next;
		while(cur!= null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}
