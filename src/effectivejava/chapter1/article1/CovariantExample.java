package effectivejava.chapter1.article1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class CovariantExample {

	class A {
	}

	class B extends A {
	}

	class C extends B {
	}

	class D extends C {
	}

	public static void main(String[] args) {
		// Ковариантность
		Stack<A> stackA = new Stack<A>();
		ArrayList<B> arrayB = new ArrayList<B>();
		stackA.pushAll(arrayB);

		// Контравариантность
		Stack<C> stackC = new Stack<C>();
		ArrayList<A> arrayA = new ArrayList<A>();
		stackC.popAll(arrayA);

	}

	public static void print(Object[] objectArray) {
		for (Object v : objectArray)
			System.out.print(v + "\n");
	}

}

class Stack<T> {
	private T[] elementData;

	private int elementCount = 0;

	private void ensureCapacityHelper(int minCapacity) {
		if (minCapacity - elementData.length > 0)
			elementData = Arrays.copyOf(elementData, 2 * elementData.length);
	}

	public Stack() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public Stack(int initialCapacity) {
		elementData = (T[]) new Object[initialCapacity];
	}

	public T push(T item) {
		ensureCapacityHelper(elementCount + 1);
		elementData[elementCount++] = item;
		return item;
	}

	public T pop() {
		T item;
		if (elementCount == 0)
			throw new EmptyStackException();
		item = elementData[elementCount - 1];
		elementCount--;
		elementData[elementCount] = null;
		return item;
	}

	/*
	 * Добавляем елементы из коллекции в стек. В качестве входного параметра
	 * можно передавать коллекции производных от T типов.
	 */
	public void pushAll(Collection<? extends T> c) {
		for (T item : c)
			push(item);
	}

	/*
	 * Извлекаем елементы из стека в коллекцию. В качестве входного параметра
	 * можно передавать коллекции супертипов для Т.
	 */
	public void popAll(Collection<? super T> c) {
		while (elementCount > 0)
			c.add(pop());
	}
}
