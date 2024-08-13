package creation_based.builder;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:47
 * @description:
 **/
public class Client {
	public static void main(String[] args) {
		StringBuilder_ stringBuilder = new StringBuilder_();
		final int count = 16;

		for(int i = 0; i < count; i++) {
			stringBuilder.append((char) ('a' + i));
		}

		System.out.println(stringBuilder.toString());
	}
}
