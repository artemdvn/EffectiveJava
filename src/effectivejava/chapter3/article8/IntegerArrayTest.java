package effectivejava.chapter3.article8;

public class IntegerArrayTest {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr3 = { 5, 4, 3 };
		IntegerArray ia1 = new IntegerArray(arr1);
		IntegerArray ia2 = new IntegerArray(arr2);
		IntegerArray ia3 = new IntegerArray(arr3);
		
		System.out.println(ia1.hashCode());
		System.out.println(ia2.hashCode());
		System.out.println(ia3.hashCode());

		// Prints true
		System.out.println(ia1.equals(ia2));

		// Prints false
		System.out.println(ia3.equals(ia2));
	}

}
