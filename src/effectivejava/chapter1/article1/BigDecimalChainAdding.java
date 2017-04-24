package effectivejava.chapter1.article1;

import java.math.BigDecimal;

public class BigDecimalChainAdding {
	
	public static void chainAdding(int initialValue, int stepValue, int stepToFinish) {
		System.out.println("-------------------------CHAIN ADDING------------------------");
		BigDecimal initial = BigDecimal.valueOf(initialValue);
		BigDecimal result = initial;
		int finishValue = (int) Math.pow(stepValue, stepToFinish);
		for (int i = stepValue; i <= finishValue; i *= stepValue) {
			result = result.add(initial.multiply(BigDecimal.valueOf(i)));
		}
		System.out.println(result);
	}

}
