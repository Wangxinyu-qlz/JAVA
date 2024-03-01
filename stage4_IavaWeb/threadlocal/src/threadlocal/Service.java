package threadlocal;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-01 16:31
 * @description:
 **/
public class Service {
	    public void update(){
        //取出threadLocal1对象关联的对象
        /**
         * get
         * public T get() {
         *          //1. 先得到当前的线程对象
         *         Thread t = Thread.currentThread();
         *         //2.通过线程获取到对应的ThrealLocalMap
         *         ThreadLocalMap map = getMap(t);
         *         if (map != null) {
         *              //3. 如果map不为空, 根据当前的 threadlocal对象，得到对应的Entry
         *             ThreadLocalMap.Entry e = map.getEntry(this);
         *             //4. 如果e 不为null
         *             if (e != null) {
         *                 @SuppressWarnings("unchecked")
         *                 //返回当前threadlocal关联的数据value
         *                 T result = (T)e.value;
         *                 return result;
         *             }
         *         }
         *         return setInitialValue();
         *     }
         *
         */
        //取出 threadLocal1 对象关联的对象
        Object o = T1.threadLocal1.get();
        //获取当前线程名
        String name = Thread.currentThread().getName();
        System.out.println("在T1Service的update() 线程name= " +
                name + " dog= " + o);
        //调用dao-update
        new T2DAO().update();
    }
}
