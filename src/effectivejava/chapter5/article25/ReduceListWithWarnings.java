package effectivejava.chapter5.article25;

import java.util.Arrays;
import java.util.List;

public class ReduceListWithWarnings {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(10, 20, 30);
		Integer result = reduce(ints, new Function<Integer>() {

			@Override
			public Integer apply(Integer arg1, Integer arg2) {
				return arg1 * arg2;
			}
		}, 1);
		System.out.println(result);
	}

	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		E[] snapshot = (E[]) list.toArray(); // Locks list
		E result = initVal;
		for (E e : snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}

	interface Function<T> {
		public T apply(T arg1, T arg2);
	}
}
