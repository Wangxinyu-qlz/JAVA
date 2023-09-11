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
				        Node<K,V>[] tab; Node<K,V> p; int n, i;//辅助变量
				        //table 是 HashMap 的一个数组，类型是Node[]
				        if ((tab = table) == null || (n = tab.length) == 0)//table:
				            n = (tab = resize()).length;
				        if ((p = tab[i = (n - 1) & hash]) == null)
				            tab[i] = newNode(hash, key, value, null);
				        else {
				            Node<K,V> e; K k;
				            if (p.hash == hash &&
				                ((k = p.key) == key || (key != null && key.equals(k))))
				                e = p;
				            else if (p instanceof TreeNode)
				                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
				            else {
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
				        if (++size > threshold)
				            resize();
				        afterNodeInsertion(evict);
				        return null;
				    }
    * */
	}
}
