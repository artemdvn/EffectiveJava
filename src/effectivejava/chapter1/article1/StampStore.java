package effectivejava.chapter1.article1;

import java.math.BigDecimal;

public class StampStore {

	public static void buyStampsWithBigDecimal(final int stampCount, double myMoneyDouble) {
		if (stampCount <= 0) {
			System.out.println("There are no stamps to buy");
			return;
		}

		System.out.println("-------------------------STAMPS WITH BIGDECIMAL------------------------");
		final BigDecimal step = BigDecimal.valueOf(0.1);
		BigDecimal stampPrice = null;
		BigDecimal myMoney = BigDecimal.valueOf(myMoneyDouble);
		for (int i = 0; i < stampCount; i++) {
			stampPrice = step.multiply(BigDecimal.valueOf(i + 1));
			myMoney = myMoney.subtract(stampPrice);
			if (myMoney.compareTo(BigDecimal.ZERO) < 0) {
				System.out.println("I have no money");
				break;
			}
			System.out.println("I have bought stamp for $" + stampPrice.toString());
		}
	}

	public static void buyStampsWithDouble(final int stampCount, double myMoney) {
		if (stampCount <= 0) {
			System.out.println("There are no stamps to buy");
			return;
		}

		System.out.println("-------------------------STAMPS WITH DOUBLE------------------------");
		final double step = 0.1;
		double stampPrice = 0.0;
		for (int i = 0; i < stampCount; i++) {
			stampPrice = step * (i + 1);
			myMoney = myMoney - stampPrice;
			if (myMoney < 0) {
				System.out.println("I have no money");
				break;
			}
//			System.out.println("I have bought stamp for $" + stampPrice);
			System.out.println(String.format("I have bought stamp for $%.1f", stampPrice));
		}
	}

	public static void buyStampsWithRoundedDouble(final int stampCount, double myMoney) {
		if (stampCount <= 0) {
			System.out.println("There are no stamps to buy");
			return;
		}

		System.out.println("-------------------------STAMPS WITH ROUNDED DOUBLE------------------------");
		final double step = 0.1f;
		double[] stamps = new double[stampCount];
		for (int i = 0; i < stampCount; i++) {
			stamps[i] = step * (i + 1);
			stamps[i] = Math.round(stamps[i] * 100);
			stamps[i] = stamps[i] / 100;
			double res = myMoney - stamps[i];
			res = Math.round(res * 100);
			res = res / 100;
			if (res < 0) {
				System.out.println("I have no money");
				break;
			}
			myMoney = res;
			System.out.println("I have bought stamp for $" + stamps[i]);
		}
	}

}
