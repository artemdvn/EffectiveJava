package effectivejava.chapter3.article8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

public class IntegerArrayTest {
	
	IntegerArray ia1;
	IntegerArray ia2;
	IntegerArray ia3;
	
	@Before
	public void setUp() {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr3 = { 5, 4, 3 };
		ia1 = new IntegerArray(arr1);
		ia2 = new IntegerArray(arr2);
		ia3 = new IntegerArray(arr3);	
	}

	@Test
	public void testIntegerArray() {
		assertTrue(ia1.equals(ia2));
		assertFalse(ia3.equals(ia2));
	}
	
	@Test
	public void testIntegerArrayUsingObjects() {
		assertTrue(Objects.equals(ia1, ia2));
		assertFalse(Objects.equals(ia3, ia2));
		
		assertTrue(Objects.deepEquals(ia1, ia2));
		assertFalse(Objects.deepEquals(ia3, ia2));
	}

}
