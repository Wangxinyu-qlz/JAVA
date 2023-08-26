/**
 * @author qiaolezi
 * @version 1.0
 */
public class EnumerationExercise {
	public static void main(String[] args) {
		Week[] days = Week.values();
		for(Week week : days) {
			System.out.println(week);
		}
	}
}

enum Week {
	MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
	FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
	private String chinese;

	Week(String chinese) {
		this.chinese = chinese;
	}

	@Override
	public String toString() {//使用 toString 方法返回 中文名称
		return chinese;
	}
}