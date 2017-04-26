package effectivejava.chapter3.article11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NonCloneablePersonCloneTest {

	private NonCloneableExtendedPerson p1;
	private NonCloneableExtendedPerson p2;
	
	@Before
	public void setUp() {
		p1 = new NonCloneableExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		p2 = new NonCloneableExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
	}

	@Test
	public void testNonCloneableExtendedPerson() {
		assertTrue(p1.equals(p2) == (p1.hashCode() == p2.hashCode()));	
	}

	@Test
	public void testNonCloneableExtendedPersonClone() {
		boolean runtimeExceptionThrown = false;
		try {
			p1.clone();
		} catch (RuntimeException e) {
			runtimeExceptionThrown = true;
		}
		assertTrue(runtimeExceptionThrown);
	}

}
