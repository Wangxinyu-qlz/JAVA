/**
 * @author qiaolezi
 * @version 1.0
 */
public class CpuNum {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
//		获取CPU核心数量
		int cpuNum = runtime.availableProcessors();
		System.out.println(cpuNum);
	}
}
