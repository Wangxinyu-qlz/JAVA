package web.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 16:07
 * @description:
 **/
@Controller
public class FileUploadHandler {
	@RequestMapping(value = "/fileUpload")
	//@RequestParam(value = "file")  前端页面和这里的参数名映射
	public String fileUpload(@RequestParam(value = "file") MultipartFile files,
	                         HttpServletRequest request, String introduce) throws IOException {

		String originalFilename = files.getOriginalFilename();
		System.out.println("上传的文件名是：" + originalFilename);
		System.out.println("文件介绍：" + introduce);

		//全路径
		String realFullPath = request.getServletContext().getRealPath("/img/" + originalFilename);
		System.out.println("全路径是" + realFullPath);

		files.transferTo(new File(realFullPath));

		return "success";
	}
}
