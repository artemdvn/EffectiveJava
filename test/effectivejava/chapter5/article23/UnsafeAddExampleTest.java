package effectivejava.chapter5.article23;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class UnsafeAddExampleTest {

	List<Object> objects;

	@Test(expected = ClassCastException.class)
	public void testUnsafeAdd() {
		List<String> strings = new ArrayList<String>();

		UnsafeAddExample.unsafeAdd(strings, new Integer(42));
		String s = strings.get(0);
	}

	@Test
	public void testSafeAdd() {
		List<Object> objects = new ArrayList<Object>();

		UnsafeAddExample.safeAdd(objects, new Integer(42));
		Object o = objects.get(0);
	}
	
	@Test
	public void testRawNumElementsInCommon() {
		Set set1 = new HashSet();
		set1.add(new Integer(42));
		Set set2 = new HashSet();
		set2.add(new String ("test"));
		
		assertEquals(0, UnsafeAddExample.rawNumElementsInCommon(set1, set2));
	}
	
	@Test
	public void testNumElementsInCommon() {
		Set<?> set1 = new HashSet<>();
		set1.add(null);
		Set<?> set2 = new HashSet<>();
		
		assertEquals(0, UnsafeAddExample.numElementsInCommon(set1, set2));
	}

}
