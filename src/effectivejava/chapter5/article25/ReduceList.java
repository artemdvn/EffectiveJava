package effectivejava.chapter5.article25;

import java.util.Arrays;
import java.util.List;

public class ReduceList {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(10, 20, 30);
		Integer result = (Integer) reduce(ints, new Function() {
			@Override
			public Object apply(Object arg1, Object arg2) {
				return (Integer) arg1 + (Integer) arg2;
			}
		}, 0);
		System.out.println(result);
	}

	static Object reduce(List list, Function f, Object initVal) {
		Object[] snapshot = list.toArray(); // Locks list internally
		Object result = initVal;
		for (Object o : snapshot) {
			result = f.apply(result, o);
		}
		return result;
	}

	interface Function {
		Object apply(Object arg1, Object arg2);
	}
}
