package effectivejava.chapter1.article1;

import java.math.BigDecimal;

public class BigIntegerTest {

	public static void main(String[] args) throws Exception {
		
		// change
		System.out.println("-------------------------CHANGE------------------------");
		System.out.println("Change BigDecimal $1 - $0.9 = $" + BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.9)));
		System.out.println("Change double $1 - $0.9 = $" + (1.0 - 0.9));

		// buy 10 stamps for 1$
		StampStore.buyStampsWithBigDecimal(10, 1);
		StampStore.buyStampsWithDouble(10, 1);
		StampStore.buyStampsWithRoundedDouble(10, 1);
		
		// 50 + 500 + 5000 + 50000
		BigDecimalChainAdding.chainAdding(50, 10, 3);
		
		// round
		BigDecimalRound.showRounding();		
        
	}

}
