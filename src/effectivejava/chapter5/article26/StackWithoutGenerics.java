package effectivejava.chapter5.article26;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackWithoutGenerics {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public StackWithoutGenerics() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		elements[size] = null; // remove old reference
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		StackWithoutGenerics stack = new StackWithoutGenerics();
		String[] arr = { "first", "second", "third" };
		for (String elem : arr) {
			stack.push(elem);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
