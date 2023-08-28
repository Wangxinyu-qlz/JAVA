import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ArrayExercise {
	public static void main(String[] args) {
		Book[] books = new Book[5];
		books[0] = new Book("qwe", 1.3);
		books[1] = new Book("q", 4.2);
		books[2] = new Book("w111", 1.4);
		books[3] = new Book("we1qew2222", 6);
		books[4] = new Book("qw22222", 5);

//		按照价格排序
//		Arrays.sort(books, new Comparator<Book>() {
//			@Override
//			public int compare(Book o1, Book o2) {//返回类型只能是int
//				Book book1 = (Book) o1;
//				Book book2 = (Book) o2;
//				double priceValue = book1.getPrice() - book2.getPrice();
////				TODO 这里的处理
//				if(priceValue > 0) {
//					return -1;
//				} else if(priceValue < 0) {
//					return 1;
//				} else {
//					return 0;
//				}
//			}
//		});

//		按照书名的长度排序
		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				Book book1 = (Book) o1;
				Book book2 = (Book) o2;
				return book1.getName().length() - book2.getName().length();
			}
		});

		System.out.println(Arrays.toString(books));
	}
}

class Book {
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
