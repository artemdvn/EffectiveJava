package effectivejava.chapter5.article25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceListWithoutWarnings {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(10, 20, 30);
		Integer result = reduce(ints, new Function<Integer>() {

			@Override
			public Integer apply(Integer arg1, Integer arg2) {
				return arg1 + arg2;
			}
		}, 0);
		System.out.println(result);
	}

	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = new ArrayList<E>(list);
		}
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
