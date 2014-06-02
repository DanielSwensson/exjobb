import java.util.*;

public class Person {
	private String namn;

	ArrayList<Pryl> prylSamling = new ArrayList<Pryl>();

	Person(String namn) {
		this.namn = namn;

	}

	public String getNamn() {
		return namn;

	}

	public String toString() {

		System.out.println(namn + ", �ger sammanlagt prylar f�r "
				+ f�rm�genhet() + "kr");
		String str = null;

		for (Pryl det : prylSamling) {
			str = det.toString();

			System.out.println(str);

		}
		return str;

	}

	public void crascha() {
		for (Pryl pr : prylSamling) {
			if (pr instanceof Aktiepost) {
				((Aktiepost) pr).setCrash();

			}
		}
	}

	public void tillPrylSamling(Pryl o) {

		prylSamling.add(o);

	}

	public double f�rm�genhet() {

		double sum = 0.0;

		for (Pryl denna : prylSamling)
			sum += denna.getV�rde();

		return sum;

	}

}
