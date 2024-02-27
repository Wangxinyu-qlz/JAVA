package tomcat.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 14:59
 * @description: 1.封装HTTP请求的数据，
 * 2.GET /CalculateServlet?num1=1&num2=9 HTTP/1.1
 * 如Method(GET) uri(CalculateServlet) 参数列表(num1=1&num2=9)
 * 3.MyRequest === 原生 servlet 中的 HttpServletRequest
 * 4.只实现GET请求
 **/
public class MyRequest {
	private String method = "";
	private String uri = "";
	//参数列表
	private final ConcurrentHashMap<String, String> parametersMapping = new ConcurrentHashMap<>();
	private InputStream inputStream  = null;

	//构造器 -> 对HTTP请求进行封装 -> 将代码封装为一个方法
	//inputStream对应于http请求的socket
	public MyRequest(InputStream inputStream) {
		this.inputStream = inputStream;
		encapsulateHttp();
	}

	//encapsulate封装
	private void encapsulateHttp( ) {
		//inputStream字节流->BufferedReader字符流
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, StandardCharsets.UTF_8));

			//读取第一行
			//"GET /CalculateServlet?num1=1&num2=9 HTTP/1.1"
			String requestLine = bufferedReader.readLine();
			//["GET", "/CalculateServlet?num1=1&num2=9", "HTTP/1.1"]
			//split()函数不能截取"?"，需要转义\\?
			String[] requestLineArray = requestLine.split(" ");
			method = requestLineArray[0];

			//1.先看又没有参数列表
			int index = requestLineArray[1].indexOf("?");
			if (index == -1) {//没有参数列表
				//解析得到 /CalculateServlet
				uri = requestLineArray[1];
			} else {
				uri = requestLineArray[1].substring(0, index);//substring:[0,index)
				//获取参数列表
				// "num1=1&num2=9"
				String parameters = requestLineArray[1].substring(index + 1);
				// ["num1=1", "num2=9"]
				String[] parametersPairs = parameters.split("&");//写错了不返回parameters
				if (null != parametersPairs && !"".equals(parametersPairs)) {
					//遍历分割数组
					for (String parameterPair : parametersPairs) {
						// ["num1", "1"]
						String[] parameterValue = parameterPair.split("=");
						if (parameterValue.length == 2) {
							parametersMapping.put(parameterValue[0], parameterValue[1]);
						}
					}
				}

			}
			//这里不能关闭流，inputStream是和socket关联的，socket会关闭
			//inputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//Request对象有一个重要方法：
	public String getParameter(String name) {
		//if (parametersMapping.containsKey(name)) {//写错了不返回parameters，contains()方法传入的参数是Value
		//	return parametersMapping.get(name);
		//	//parametersMapping.containsKey(Key);
		//	//parametersMapping.containsValue(Value);
		//	//parametersMapping.contains(Value);
		//} else {
		//	return "";
		//}
		//与上面的代码实现的功能星相同
		//public V getOrDefault(Object key, V defaultValue) {
		//        V v;
		//        return (v = get(key)) == null ? defaultValue : v;
		//    }
		return parametersMapping.getOrDefault(name, "");
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "MyRequest{" + "method='" + method + '\'' + ", uri='" + uri + '\'' + ", parametersMapping=" + parametersMapping + '}';
	}
}
