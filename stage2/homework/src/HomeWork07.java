/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork07 {
	public static void main(String[] args) {
		Carcar carcar = new Carcar(55);
		carcar.getAir().flow();

		Carcar carcar1 = new Carcar(-99);
		carcar1.getAir().flow();
	}
}

class Carcar {
	private double temperature;

	public Carcar(double temperature) {
		this.temperature = temperature;
	}

	class Air {
		public void flow() {
			if(temperature > 40) {
				System.out.println("吹冷风.");
			} else if(temperature < 0) {
				System.out.println("吹暖风.");
			} else {
				System.out.println("关闭.");
			}
		}
	}
	public Air getAir() {
		return new Air();
	}
}
