package src;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-09-13 09:27
 * @description:
 **/
public class I_ {
	public static void main(String[] args) {
		int index=2;
		switch (index) {
			case 1 :
				System.out.println(1);
				break;
			default:
				System.out.println(2);
		}

		int i = 1;
		int j = i++;
		if((j>++j) && (i++==j)) {
			j+=i;
		}
		System.out.println(i + " " + j);//2 2
	}
}
