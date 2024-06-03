package qiaolezi.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 20:02
 * @description:
 **/
@Slf4j
@Controller
public class UploadController {
	@GetMapping("/upload.html")
	public String uploadPage() {
		return "upload";
	}

	@ResponseBody
	@PostMapping("/upload")
	public String upload(@RequestParam("email")String email,
	                     @RequestParam("name")String name,
	                     @RequestParam("age")String age,
	                     @RequestParam("job")String job,
	                     @RequestPart("header") MultipartFile header,
	                     @RequestPart("photo")MultipartFile[] photos) throws IOException {
		//动态创建上传文件夹
		String path = ResourceUtils.getURL("classpath:").getPath();
		System.out.println(path);
		File file = new File(path+"static/images/upload");
		if(!file.exists()){
			file.mkdirs();
		}

		if(!header.isEmpty()) {
			//保存文件到服务器
			String originalFilename = header.getOriginalFilename();
			//方式1 指定目录
			header.transferTo(new File(path+"static/images/upload/" + originalFilename));
			//方式2 动态创建文件夹存放文件
			System.out.println(file.getAbsolutePath());
			//header.transferTo(new File(file.getAbsolutePath() + "/" + originalFilename));
		}
		if(photos.length > 0) {
			for(MultipartFile photo : photos) {
				if(!photo.isEmpty()) {
					String originalFilename = photo.getOriginalFilename();
					photo.transferTo(new File(path+"static/images/upload/" + originalFilename));
				}
			}
		}

		return "上传成功！";
	}
}
