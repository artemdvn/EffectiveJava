package effectivejava.chapter1.article1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantArrayTest {

	public static void main(String[] args) {
		Number[] numberArray = new Number[5];
		numberArray[0] = 3.14;

		Integer[] integerArray = { 1, 2, 3, 4, 5 };

		numberArray = integerArray; // OK
		// integerArray = numberArray; //ERROR!
		
		// numberArray[0] = 1L; //java.lang.ArrayStoreException
		
		Double[] doubleArray = { 1.0, 2.1, 3.2, 4.3, 5.4 };

		System.out.println("Array sum: " + arraySum(numberArray));
		System.out.println("Array sum: " + arraySum(doubleArray));
		
		
		// lists
		List<Number> numberList = new ArrayList<Number>();
		numberList.add(3.14);
		
		List<Integer> integerList = Arrays.asList(integerArray);
		
		//numberList = integerList; // ERROR!
		//integerList = numberList; //ERROR!
		
		numberList.set(0, 1L);
		
		List<Double> doubleList = Arrays.asList(doubleArray);
		
		System.out.println("List sum: " + listSum(numberList));
		//System.out.println("List sum: " + listSum(doubleList)); //ERROR!
		
		System.out.println("Covariant list sum: " + covariantListSum(numberList));
		//System.out.println("Covariant list sum: " + covariantListSum(doubleList));
		
		//copyList(numberList, doubleList);
		
		System.out.println("Number list: " + getNumberList(integerList, doubleList));
	
	}

	private static long arraySum(Number[] arr) {
		long sum = 0;
		for (Number elem : arr) {
			sum = sum + elem.longValue();
		}
		return sum;
	}
	
	private static long listSum(List<Number> list) {
		long sum = 0;
		for (Number elem : list) {
			sum = sum + elem.longValue();
		}
		return sum;
	}
	
	private static long covariantListSum(List<? extends Number> list) {
		long sum = 0;
		for (Number elem : list) {
			sum = sum + elem.longValue();
		}
		return sum;
	}
	
	private static long copyList(List<? extends Number> listProducer, List<? super Number> listConsumer) {
		long sum = 0;
		for (Number elem : listProducer) {
			listConsumer.add(elem.intValue());
		}
		System.out.println(listConsumer);
		return sum;
	}
	
	private static List<? super Number> getNumberList(List<? extends Number> firstList, List<? extends Number> secondList) {
		List<Object> numberList = new ArrayList<Object>();
		for (Number elem : firstList) {
			numberList.add(elem);
		}
		for (Number elem : secondList) {
			numberList.add(elem);
		}
		return numberList;
	}

}
