import java.io.*;

/**
 * @author qiaolezi
 * @version 1.0
 * TODO 可以操作文本文件 不会乱码
 */
public class BufferedCopyStream {
	public static void main(String[] args) {
//		String srcFilePath = "C:\\My_Code\\Java\\stage2\\file\\test.jpg";
//		String destFilePath = "C:\\My_Code\\Java\\stage2\\file\\test(2).jpg";
		String srcFilePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		String destFilePath = "C:\\My_Code\\Java\\stage2\\file\\story(2).txt";
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));

			byte[] buffer = new byte[1024];
			int readLength = 0;
			while((readLength = bufferedInputStream.read(buffer)) != -1) {
				bufferedOutputStream.write(buffer, 0, readLength);
			}

			System.out.println("拷贝完毕！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedInputStream != null) {
						bufferedInputStream.close();
				}
				if(bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
