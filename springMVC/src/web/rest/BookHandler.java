package web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 10:59
 * @description: 处理rest风格的请求
 **/
@RequestMapping("/user")
@Controller
public class BookHandler {
	//查询[GET]
	/**
	 * <a href="user/book/200">点击查询书籍</a>
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/book/{id}")
	public String getBook(@PathVariable("id") String id){
		System.out.println("查询书籍 id=" + id);
		return "success";
	}

	/**
	 * <form action="user/book" method="post">
	 *     name:<input name="bookName" type="text"><br>
	 *     <input type="submit" value="添加书籍">
	 * </form>
	 * @param bookName
	 * @return
	 */
	//添加[Post]
	@PostMapping(value = "/book")
	public String addBook(String bookName){
		System.out.println("添加书籍 bookName=" + bookName);
		return "success";
	}

	//删除[DELETE]
	@DeleteMapping(value = "/book/{id}")
	public String deleteBook(@PathVariable("id") String id){
		System.out.println("删除书籍 id=" + id);
		//return "success";//Error:JSPs only permit GET POST or HEAD
		//1.重定向 redirect:/user/success
		//2.解析成："/springMVC/user/success"

		//请求头：POST /springMVC/user/book/600 HTTP/1.1
		//响应：
		//    HTTP/1.1 302 Found    重定向
		//    Location: /springMVC/user/success
		return "redirect:/user/success";
	}

	//如果请求是 /user/success, 就转发到 success.jsp
	@RequestMapping(value = "/success")
	public String successGeneral(){
		return "success";//由该方法 转发到 success.jsp 页面
	}

	@PutMapping(value = "/book/{id}")
	public String updateBook(@PathVariable("id") String id){
		System.out.println("修改书籍 id=" + id);
		return "redirect:/user/success";
	}
}
