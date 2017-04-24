package effectivejava.chapter1.article1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BigDecimalRound {
	
	public static void showRounding() {
		System.out.println("-------------------------ROUND------------------------");
		ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();
		list.add(new BigDecimal("100.12"));
		list.add(new BigDecimal("100.44"));
		list.add(new BigDecimal("100.50"));
		list.add(new BigDecimal("100.75"));
		list.add(new BigDecimal("-100.12"));
		list.add(new BigDecimal("-100.44"));
		list.add(new BigDecimal("-100.50"));
		list.add(new BigDecimal("-100.75"));
		
		for (BigDecimal bd : list) {
			System.out.println(bd + " HALF_UP-> " + bd.setScale(0, RoundingMode.HALF_UP).setScale(2));
			System.out.println(bd + " DOWN-> " + bd.setScale(0, RoundingMode.DOWN).setScale(2));
			System.out.println(bd + " UP-> " + bd.setScale(0, RoundingMode.UP).setScale(2));
			System.out.println(bd + " CEILING-> " + bd.setScale(0, RoundingMode.CEILING).setScale(2));
			System.out.println(bd + " FLOOR-> " + bd.setScale(0, RoundingMode.FLOOR).setScale(2));
			System.out.println(bd + " HALF_DOWN-> " + bd.setScale(0, RoundingMode.HALF_DOWN).setScale(2));
			System.out.println(bd + " HALF_EVEN-> " + bd.setScale(0, RoundingMode.HALF_EVEN).setScale(2));
		}
	}

}
