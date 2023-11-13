/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashSetStructure {
	public static void main(String[] args) {
//		模拟 HashMap 的底层结构

//		创建一个数组，类型是 Node[]
//		Node[] 也叫作 table
		Node1[] table = new Node1[16];
		System.out.println(table);//[LNode1;@1b6d3586

//		创建结点
		Node1 john = new Node1("john", null);
		table[2] = john;
		Node1 a = new Node1("a", null);
		john.next = a;//将a结点挂载到john结点的后面
		Node1 rose = new Node1("Rose", null);
		a.next = rose;

		Node1 b = new Node1("b", null);
		table[3] = b;
	}
}

class Node1 {
	Object item;
	public Node1 pre;
	public Node1 next;

	public Node1(Object name, Node1 next) {
		this.item = name;this.next = next;
	}

	@Override
	public String toString() {
		return "Node1{" +
				"item=" + item +
				'}';
	}
}
