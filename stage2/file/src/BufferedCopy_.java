import java.io.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class BufferedCopy_ {
	public static void main(String[] args) throws IOException {
		String srcFilePaht = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		String destFilePath = "C:\\My_Code\\Java\\stage2\\file\\story(1).txt";
		String line;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFilePaht));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
//		TODO raedLine读取一行的内容，但是不包括换行符
		while((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}

//      关闭流
		if(bufferedReader != null) {
			bufferedReader.close();
		}
		if(bufferedWriter != null) {
			bufferedWriter.close();
		}
	}
}
