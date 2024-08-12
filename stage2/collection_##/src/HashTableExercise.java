import java.util.Hashtable;

/**
 * @author qiaolezi
 * @version 1.0
 * 线程安全
 * HashTable是过期的类，现在都用ConcurrentHashMap，因为它加锁粒度更低
 */
public class HashTableExercise {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		/*
		public Hashtable() {
            this(11, 0.75f);
        }
		 */
		Hashtable table = new Hashtable();//OK
		table.put("john", 100);//OK
//		table.put(null, 100);//NullPointerException
//		table.put("john", null);//NullPointerException
		table.put("picture", 100);//OK
		table.put("pic", 77);//替换
		table.put("1", 100);//OK
		table.put("2", 100);//OK
		table.put("3", 100);//OK
		table.put("4", 100);//OK
		table.put("5", 100);//OK
		table.put("6", 100);//OK
		table.put("7", 100);//OK

//		简单说明一下Hashtable底层代码
//		1.底层有数组 Hashtable$Entry[] 初始化大小为11
//		2.threshold 8 = 11 * 0.75
//      3.扩容机制：有自己的扩容机制
//		4.执行方法：addEntry(hash, key, value, index); 添加K-V 封装到Entry
//		5.当 if(count >. threshold) 满足时，进行扩容
//		按照 int newCapacity = (oldCapacity << 1) + 1; 的大小扩容

	}
}
