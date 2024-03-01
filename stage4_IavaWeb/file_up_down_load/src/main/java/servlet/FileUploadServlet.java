package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-01 17:34
 * @description:
 **/
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("up");
		//1.判断是不是文件表单，(enctype="multipart/form-data")
		if(ServletFileUpload.isMultipartContent(req)) {
			//System.out.println("OK");
			//2.创建DiskFileItemFactory 对象，用于构建一个解析上传数据的工具对象
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			//3.创建一个解析上传数据的工具对象
			/**
			 * 表单提交的数据就是 input 元素
			 *     <input type="file" name="pic" id="" value="" onchange="prev(this)"/>
			 *     家居名: <input type="text" name="name"><br/>
			 *     <input type="submit" value="上传"/>
			 */
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

			//4.关键：servletFileUpload对象可以将表单提交的数据（text/文件）
			//封装到FileItem 文件项中
			//解决接收到的文件名是乱码
			servletFileUpload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(req);
				/**
				 * fileItems=
				 * [name=鍗￠?氬ご鍍?.png,
				 * StoreLocation=C:\My_Code\Java\stage4_IavaWeb\apache-tomcat-8.0.50\temp\
				 * upload_5b271c14_f05a_4402_a5ef_8f9df3f73131_00000000.tmp,
				 * size=38070 bytes, isFormField=false, FieldName=pic,
				 * name=null,
				 * StoreLocation=C:\My_Code\Java\stage4_IavaWeb\apache-tomcat-8.0.50\
				 * temp\\upload_5b271c14_f05a_4402_a5ef_8f9df3f73131_00000001.tmp,
				 * size=3 bytes, isFormField=true, FieldName=name]
				 */
				//System.out.println("fileItems=" + fileItems);//TODO 如果不知道一个对象的结构，就输出

				//遍历并分别处理
				for (FileItem fileItem : fileItems) {
					//System.out.println("fileItem=" + fileItem);
					if(fileItem.isFormField()) {//是文本 input text
						String string = fileItem.getString("utf-8");
						//System.out.println("家具名字=" + string);
					} else {//文件
						String name = fileItem.getName();
						//System.out.println(name);
						//将这个上传到服务器的文件保存到指定的目录，JavaWeb项目的真实访问的目录是out/target
						//1.指定一个目录，网站工作目录
						String filePath = "\\upload\\";
						//TODO 2.获取完整目录 req.getServletContext()报错，先.getSession()
						String realPath = req.getSession().
								getServletContext().getRealPath(filePath);
						//System.out.println("filePath=" + realPath);
						//3.创建上传目录
						File fileRealPathDirectory = new File(realPath + "\\" +WebUtils.getYearMonthDay());
						if(!fileRealPathDirectory.exists()) {//目录不存在
							fileRealPathDirectory.mkdirs();
						}
						//4.将文件拷贝到fileRealPathDirectory目录
						//构建上传文件的完整路径
						name = UUID.randomUUID().toString() + System.currentTimeMillis() +
								"_" + name;
						String fileFullPath = fileRealPathDirectory + "\\" + name;
						System.out.println(fileFullPath);
						//TODO ？目录中并没有保存的文件，且没有异常抛出
						fileItem.write(new File(name));
						//5.提示信息
						resp.setContentType("text/html;charset=utf-8");
						resp.getWriter().write("上传成功！");
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			System.out.println("不是文件表单");
		}
	}
}
