package effectivejava.chapter5.article27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionSets {

	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	public static void main(String... args) {
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Alex", "Rich"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> united = union(guys, stooges);
		System.out.println(united);
	}

}
