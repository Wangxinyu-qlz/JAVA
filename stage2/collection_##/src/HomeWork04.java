import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork04 {
	public static void main(String[] args) {
		News news = new News("新闻一：新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
		News news1 = new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
		News news2 = new News("新闻三：日本第一男枪被告");

		ArrayList arrayList = new ArrayList();
		arrayList.add(news);
		arrayList.add(news1);
		arrayList.add(news2);

		for (int i = arrayList.size() - 1; i >= 0; i--) {
			News new_ = (News) arrayList.get(i);
			System.out.println(processTitle(new_.getTitle()));
		}
	}

	public static String processTitle(String title) {
		if(title == null) {
			return "";
		}

		if(title.length() > 15) {
			return title.substring(0, 15) + "...";
		} else {
			return title;
		}
	}
}

class News {
	private String title;
	private String content;

	public News(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return this.title;
	}
}