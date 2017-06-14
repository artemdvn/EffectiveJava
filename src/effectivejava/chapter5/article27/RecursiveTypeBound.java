package effectivejava.chapter5.article27;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Using a recursive type bound to express mutual comparability
public class RecursiveTypeBound {
	// Returns the maximum value in a list - uses recursive type bound
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0){
				result = t;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> argList = Arrays.asList("1", "25", "-ttt");
		System.out.println(max(argList));
	}
}
