package effectivejava.chapter3.article12;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CompareToTest {

	private PhoneNumber pn1;
	private PhoneNumber pn2;
	private PhoneNumber pn3;
	private PhoneNumber pn4;

	@Before
	public void setUp() {
		pn1 = new PhoneNumber(1, 2, 3);
		pn2 = new PhoneNumber(5, 6, 7);
		pn3 = new PhoneNumber(5, 22, 87);
		pn4 = new PhoneNumber(5, 22, 87);
	}

	@Test
	public void testPhoneNumberCompareTo() {

		assertTrue(pn1.compareTo(pn1) == 0);

		assertTrue(pn1.compareTo(pn2) == -pn2.compareTo(pn1));

		assertTrue(pn3.compareTo(pn2) > 0 && pn2.compareTo(pn1) > 0 && pn3.compareTo(pn1) > 0);

		assertTrue(pn3.compareTo(pn4) == 0 && pn3.compareTo(pn1) == pn4.compareTo(pn1));

		assertTrue((pn3.compareTo(pn4) == 0) == pn3.equals(pn4));

	}

	@Test(expected = NullPointerException.class)
	public void testPhoneNumberCompareToNPEThrown() {
		pn2.compareTo(null);
	}

	@Test
	public void testBigDecimalCompareTo() {
		BigDecimal bd1 = new BigDecimal("2.0");
		BigDecimal bd2 = new BigDecimal("2.00");

		assertTrue(bd1.compareTo(bd2) == 0);
		assertFalse(bd1.equals(bd2));
	}

	@Test(expected = ClassCastException.class)
	public void testPersonCompareToClassCastExceptionThrown() {
		BasePerson p = new BasePerson("Alex", 12);
		ExtendedPerson ep = new ExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		ep.compareTo((ExtendedPerson) p);
	}

	@Test
	public void testPhoneNumberShortOverflowProblem() {
		PhoneNumberWithIntegerOverflowProblem pn1 = new PhoneNumberWithIntegerOverflowProblem(Integer.MAX_VALUE, 2, 3);
		PhoneNumberWithIntegerOverflowProblem pn2 = new PhoneNumberWithIntegerOverflowProblem(Integer.MIN_VALUE, 2, 3);

		assertFalse(pn1.compareTo(pn2) > 0);
	}

	@Test
	public void testPhoneNumberCompareToUsingComparator() {
		PhoneNumber pn11 = new PhoneNumber(1, 2, 13);
		PhoneNumber pn12 = new PhoneNumber(5, 6, 7);
		List<PhoneNumber> numbers = new ArrayList<>();
		numbers.add(pn11);
		numbers.add(pn12);

		assertTrue(pn11.compareTo(pn12) < 0);
		assertTrue(new LineNumberComparator().compare(pn11, pn12) > 0);

		// without lambda
		numbers.sort(new LineNumberComparator());
		assertTrue(numbers.get(0) == pn12);
		
		// prefix comparator with lambda
		numbers.sort((pn1, pn2) -> {
			if (pn1.getPrefix() < pn2.getPrefix()) {
				return -1;
			}
			if (pn1.getPrefix() > pn2.getPrefix()) {
				return 1;
			}
			return 0;
		});
		assertTrue(numbers.get(0) == pn11);
	}

}
