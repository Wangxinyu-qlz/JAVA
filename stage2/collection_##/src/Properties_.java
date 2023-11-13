import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Properties_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		1.Properties 继承 Hashtable
//		2.可以通过 K-V 存放数据，均不能为 null
//		3.
		Properties properties = new Properties();
		properties.put("john", 100);
//		properties.put(null, 100);//NullPointerException
//		properties.put("2", null);//NullPointerException
		properties.put("licture", 100);
		properties.put("lic", 100);
		properties.put("lic", 88);//替换

		System.out.println(properties);//{john=100, lic=88, licture=100}

		System.out.println(properties.get("lic"));//88
		properties.remove("licture");
		System.out.println(properties);

		properties.put("lic", "###");
		System.out.println(properties);

		System.out.println(properties.getProperty("lic"));
	}
}
