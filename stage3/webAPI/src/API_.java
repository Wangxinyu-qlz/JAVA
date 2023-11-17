/**
 * @author qiaolezi
 * @version 1.0
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
	public static void main(String[] args) throws UnknownHostException {
//		获取本机的主机名称和IP地址
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);//qiaolezi/10.102.14.224

//		根据主机名获取InetAddress对象
		InetAddress qiaolezi = InetAddress.getByName("qiaolezi");
		System.out.println(qiaolezi);//qiaolezi/10.102.14.224

//		根据域名获取InetAddress对象
		InetAddress baidu = InetAddress.getByName("www.baidu.com");
		System.out.println(baidu);//www.baidu.com/110.242.68.3

//		根据InetAddress对象，获取IP地址
		String baiduHostAddress = baidu.getHostAddress();
		System.out.println(baiduHostAddress);//110.242.68.4

//		根据InetAddress对象，获取主机名/域名
		String baiduHostName = baidu.getHostName();
		System.out.println(baiduHostName);//www.baidu.com
	}
}
