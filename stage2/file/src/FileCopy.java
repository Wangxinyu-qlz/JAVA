import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class FileCopy {
	public static void main(String[] args) {
		//文件拷贝
		//1.创建文件的输入流，将文件读入到程序
		//2.创建文件的输出流，将读取的文件数据写入到指定的文件

		String srcFilePath = "C:\\My_Code\\Java\\stage2\\file\\test.jpg";
		String destFilePath = "C:\\My_Code\\Java\\stage2\\file\\test(1).jpg";
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			fileInputStream = new FileInputStream(srcFilePath);
			fileOutputStream = new FileOutputStream(destFilePath);
//			定义字节数组，提高效率
			byte[] buffer = new byte[1024];
			int readLength = 0;
			while((readLength = fileInputStream.read(buffer)) != -1) {
//				读取后就写入，边读边写
//				TODO 最后剩余的字节数 < 1024，该方法不会多写入无效数据
				fileOutputStream.write(buffer, 0, readLength);
			}
			System.out.println("拷贝完成！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			关闭输入流和输出流
			if(fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if(fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}
}