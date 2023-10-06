import java.nio.Buffer;

/**
 * @author qiaolezi
 * @version 1.0
 * TODO 修饰器设计模式
 */
public abstract class Reader_ {//抽象类
	public void readFile() {};
	public void readString() {};
}

class FileReader1 extends Reader_ {

	public void readFile() {
		System.out.println("文件读取");
	}

}

class StringReader1 extends Reader_ {

	public void readString() {
		System.out.println("字符串读取");
	}
}

class BufferReader_ extends Reader_ {
	private Reader_ reader_;//

	public BufferReader_(Reader_ reader_) {
		this.reader_ = reader_;
	}

	public void readFile() {//封装
		reader_.readFile();
	}

	//	让方法更灵活，批量处理大文件
	public void readFiles(int num) {
		for (int i = 0; i < num; i++) {
			reader_.readFile();
		}
	}

//	扩展readString，批量处理字符串
	public void readString(int num) {
		for (int i = 0; i < num; i++) {
			reader_.readString();
		}
	}

}

class Test_ {
	public static void main(String[] args) {
		BufferReader_ bufferReader_ = new BufferReader_(new FileReader1());
		bufferReader_.readFiles(10);
		bufferReader_.readFile();

		BufferReader_ bufferReader_1 = new BufferReader_(new StringReader1());
		bufferReader_1.readString(3);
	}
}
