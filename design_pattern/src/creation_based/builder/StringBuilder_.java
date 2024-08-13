package creation_based.builder;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:47
 * @description:
 **/
public class StringBuilder_ extends AbstractStringBuilder_{
	public StringBuilder_() {
		super(16);
	}

	@Override
	public String toString() {
		return new String(value, 0, count);
	}
}
