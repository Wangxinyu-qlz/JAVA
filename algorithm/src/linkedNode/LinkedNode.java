package linkedNode;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-30 09:12
 * @description:
 **/
public class LinkedNode {
	int val;
	LinkedNode next;
	public LinkedNode () {}

	public LinkedNode(int val, LinkedNode next) {
		this.val = val;
		this.next = next;
	}

	public static void main(String[] args) {
		LinkedNode linkedNode = new LinkedNode();
		linkedNode.val = 1;
		linkedNode.next = new LinkedNode(2, null);

		LinkedNode q = linkedNode;
		while( q != null) {
			System.out.print(q.val + " ");
			q = q.next;
		}
	}

}
