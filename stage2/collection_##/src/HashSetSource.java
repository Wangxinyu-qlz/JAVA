import java.util.HashSet;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashSetSource {
	public static void main(String[] args) {
		/*
		* 1.HashSet底层是HashMap
		* 2.添加一个元素时，先得到 hash值，转换为 索引值
		* 3.找到存储数据表table，查看索引位置是否已经存放元素
		* 4.如果没有，直接添加
		* 5.如果有，调用equals方法比较，如果相同，放弃添加，否则添加到最后
		* 6.在JAVA8中，如果一条链表的元素个数达到TREEIFY_THRESHOLD(默认为8)，
		*   并且table的达标 >= MIN_TREEIFY_CAPACITY(默认64)，进行树化（红黑树）
		* */

		HashSet hashSet = new HashSet();
		hashSet.add("java");
		hashSet.add("Python");
		hashSet.add("java");
		System.out.println("set=" + hashSet);//set=[java, Python]

		/*
		* 1.    public HashSet() {map = new HashMap<>();}
		* 2.    public boolean add(E e) {return map.put(e, PRESENT)==null;}
		* 3.    static final int hash(Object key) {int h; return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);}
		* 4.执行   final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
				        collection.Node<K,V>[] tab; collection.Node<K,V> p; int n, i;//辅助变量
				        //table 是 HashMap 的一个数组，类型是Node[]
				        //if 语句表示如果当前table 是null，或者大小=0
				        //就进行第一次扩容，到16个
				        if ((tab = table) == null || (n = tab.length) == 0)//table:
				            n = (tab = resize()).length;
				        //（1）根据key，得到hash值，计算key的存放位置（table中的索引值）
				        //并将该位置的对象，赋值给 p
				        //（2）判断 p 是否为 null
				        //（2.1）如果 p 为 null，表示该位置没有存放元素，就创建一个Node(key="java", value=PRESENT)
				        //（2.2）放在该位置：tab[i] = newNode(hash, key, value, null);
				        if ((p = tab[i = (n - 1) & hash]) == null)
				            tab[i] = newNode(hash, key, value, null);
				        else {
				            //开发技巧提示：局部变量（辅助）定义在需要的地方
				            collection.Node<K,V> e; K k;
				            //如果当前索引位置对应的链表的第一个元素 和 准备添加的key的hash值一样
				            //并且满足以下两个条件之一：
				            //（1）准备加入的 key 和 p指向的Node结点的 key 是同一个对象
				            //（2）p 指向的Node结点的 key的equals()方法 和准备加入的key比较后相同
				            //就不能加入
				            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
				                e = p;
				            //再判断 p 是不是红黑树
				            //如果是红黑树，就调用 putTreeVal 添加
				            else if (p instanceof TreeNode)
				                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
				            //如果table对应的索引位置已经是一个链表，就使用for循环比较
				            else {
				                //（1）依次和该链表的每一个元素比较，如果都不相同，则加入到该链表的最后
				                //     注意在把元素添加到链表后，立即判断是否已经达到8个结点
				                //       ，就调用 treeifyBin() 对当前链表进行树化
				                //     注意：进行树化前，要判断：如果该table数组<64 || table==null
				                //     先对table扩容
				                //     只有上述条件不成立时，才进行树化
				                //（2）在比较的过程中，如果有相同，就放弃添加，break
				                for (int binCount = 0; ; ++binCount) {
				                    if ((e = p.next) == null) {
				                        p.next = newNode(hash, key, value, null);
				                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
				                            treeifyBin(tab, hash);
				                        break;
				                    }
				                    if (e.hash == hash &&
				                        ((k = e.key) == key || (key != null && key.equals(k))))
				                        break;
				                    p = e;
				                }
				            }
				            if (e != null) { // existing mapping for key
				                V oldValue = e.value;
				                if (!onlyIfAbsent || oldValue == null)
				                    e.value = value;
				                afterNodeAccess(e);
				                return oldValue;
				            }
				        }
				        ++modCount;
				        //size 是加入的每一个结点的总数，不管在table中【第一个结点】，还是挂在结点的后面
				        if (++size > threshold)
				            resize();
				        afterNodeInsertion(evict);
				        return null;
				    }
        * */
	}
}
