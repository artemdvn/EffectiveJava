package effectivejava.chapter1.article5;

// Java maintains Integer pool from -128 to 127
// We can change the range using JVM variable 
// -Djava.lang.Integer.IntegerCache.high=4096
public class IntegerPoolTest {

	public static void main(String[] args) {

		integerPoolTest(15);
		integerPoolTest(150);
		integerPoolTest(1500);
		integerPoolTest(15000);

		longPoolTest(15L);
		longPoolTest(150L);

		Short value = 15;
		shortPoolTest(value);
		value = 150;
		shortPoolTest(value);

		doublePoolTest(15.5);
		doublePoolTest(150.5);

	}

	private static void integerPoolTest(int value) {
		System.out.println("-----------------------INTEGER------------" + value + "---------------------");
		Integer i1 = value;
		Integer i2 = value;
		Integer i3 = new Integer(value);
		Integer i4 = new Integer(value);

		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1 == i3: " + (i1 == i3));
		System.out.println("i3 == i4: " + (i3 == i4));
	}

	private static void longPoolTest(long value) {
		System.out.println("-----------------------LONG------------" + value + "---------------------");
		Long i1 = (Long) value;
		Long i2 = (Long) value;
		Long i3 = new Long(value);
		Long i4 = new Long(value);

		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1 == i3: " + (i1 == i3));
		System.out.println("i3 == i4: " + (i3 == i4));
	}

	private static void shortPoolTest(short value) {
		System.out.println("-----------------------SHORT------------" + value + "---------------------");
		Short i1 = (Short) value;
		Short i2 = (Short) value;
		Short i3 = new Short(value);
		Short i4 = new Short(value);

		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1 == i3: " + (i1 == i3));
		System.out.println("i3 == i4: " + (i3 == i4));
	}

	private static void doublePoolTest(double value) {
		System.out.println("-----------------------DOUBLE------------" + value + "---------------------");
		Double i1 = value;
		Double i2 = value;
		Double i3 = new Double(value);
		Double i4 = new Double(value);

		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1 == i3: " + (i1 == i3));
		System.out.println("i3 == i4: " + (i3 == i4));
	}

}
