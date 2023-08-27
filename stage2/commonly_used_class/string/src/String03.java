/**
 * @author qiaolezi
 * @version 1.0
 */
public class String03 {
	public static void main(String[] args) {
//		下面两条语句创建了两个对象，在常量池中。
//		s1首先指向常量池中的"haha"
//		s1 = "wuwu";语句，查找常量池中有没有"wuwu"
//		如果有直接指向，如果没有创建后指向（不指向"haha"了）
		String s1 = "haha";
		s1 = "wuwu";
	}
}
