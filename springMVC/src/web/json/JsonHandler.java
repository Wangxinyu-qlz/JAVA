package web.json;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.json.entity.Dog;
import web.json.entity.User;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 21:41
 * @description:
 **/
@RestController  //相当于 @ResponseBody + @Controller
//@ResponseBody
//@Controller
public class JsonHandler {
	@RequestMapping(value = "/json/dog")
	//@ResponseBody：SpringMVC会根据目标方法的这个注解，返回指定格式，根据http请求处理
	//@ResponseBody
	public Dog getJson() {
		Dog dog = new Dog();
		dog.setName("大黄");
		dog.setAddress("山海");

		return dog;
	}

	@RequestMapping(value = "/json/dog2")
	//@ResponseBody
	public Map<String, Dog> getJsonMap() {
		Map<String, Dog> map = new HashMap<String, Dog>();
		map.put("大黄", new Dog("大黄", "北京"));
		map.put("小黑", new Dog("小黑", "上海"));

		return map;
	}

	@RequestMapping(value = "/json/dog3")
	//@ResponseBody
	public List<Dog> getJsonList() {
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("大黄", "北京"));
		dogs.add(new Dog("小黑", "上海"));

		return dogs;
	}

	//TODO @RequestBody User user
	//springMVC会将提交的 json 字符串数据填充给指定的JavaBean
	//@ResponseBody
	@RequestMapping(value = "/save2")
	public User save2(@RequestBody User user) {
		System.out.println("user=" + user);
		return user;
	}

	@RequestMapping(value = "/downFile")
	public ResponseEntity<byte[]> downFile(HttpSession httpSession)
			throws Exception{
		//构建一个ResponseEntity对象 1.http响应头headers 2.http响应状态 3.下载的文件

		//1.获取现在文件的stream
		//这种方法无法获取到
		//InputStream resourceAsStream = httpSession.getServletContext().getResourceAsStream("/img/1.jpg");
		//TODO Maven构建的项目，src/main/resources目录下的资源文件，通过ClassPathResource来加载
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("img/1.jpg");
		//2.存放文件的 byte[]
		System.out.println(resourceAsStream);
		byte[] buffer = new byte[resourceAsStream.available()];
		//3.将下载到的文件存放到 byte[]
		resourceAsStream.read(buffer);
		//4.创建返回的status和headers
		HttpStatus status = HttpStatus.OK;
		HttpHeaders httpHeaders = new HttpHeaders();
		//指定返回的数据，客户端应当以附件形式处理    attachment:以附件形式下载
		httpHeaders.add("Content-Disposition",
						"attachment;filename=1.jpg");

		ResponseEntity<byte[]> responseEntity =
				new ResponseEntity<>(buffer, httpHeaders, status);

		return responseEntity;
	}
}
