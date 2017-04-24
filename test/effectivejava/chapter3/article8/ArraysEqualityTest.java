package effectivejava.chapter3.article8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ArraysEqualityTest {

	int[] arr1 = { 1, 2, 3 };
	int[] arr2 = { 1, 2, 3 };
	int[] arr3 = { 5, 4, 3 };

	int[][] arr2D1 = { { 1, 2, 3 }, { 1, 2, 3 } };
	int[][] arr2D2 = { { 1, 2, 3 }, { 1, 2, 3 } };
	int[][] arr2D3 = { { 1, 2, 3 }, { 5, 4, 3 } };

	@Test
	public void testArraysEquals() {
		assertTrue(Arrays.equals(arr1, arr2));
		assertFalse(Arrays.equals(arr3, arr2));
	}

	@Test
	public void testArrays2DEquals() {
		assertFalse(Arrays.equals(arr2D1, arr2D2));
		assertFalse(Arrays.equals(arr2D3, arr2D2));
	}

	@Test
	public void testArraysDeepEquals() {
		// needs arrays of Objects
		Integer[] arr1 = { 1, 2, 3 };
		Integer[] arr2 = { 1, 2, 3 };
		Integer[] arr3 = { 5, 4, 3 };

		assertTrue(Arrays.deepEquals(arr1, arr2));
		assertFalse(Arrays.deepEquals(arr3, arr2));
	}

	@Test
	public void testArrays2DDeepEquals() {
		assertTrue(Arrays.deepEquals(arr2D1, arr2D2));
		assertFalse(Arrays.deepEquals(arr2D3, arr2D2));
	}

}
