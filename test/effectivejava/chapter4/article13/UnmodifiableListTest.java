package effectivejava.chapter4.article13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UnmodifiableListTest {

	private List<String> modifiableList;
	private List<String> unModifiableList;
	private List<String> immutableList;

	@Before
	public void setUp() {
		modifiableList = new ArrayList<String>();
		modifiableList.add("a");

		unModifiableList = Collections.unmodifiableList(modifiableList);

		immutableList = Collections.unmodifiableList(new ArrayList<String>(modifiableList));
	}

	@Test
	public void testModifiableList() {

		assertEquals(1, modifiableList.size());

		modifiableList.add("b");
		assertEquals(2, modifiableList.size());

		modifiableList.add("c");
		assertEquals(3, modifiableList.size());

	}

	@Test(expected = UnsupportedOperationException.class)
	public void testAddToUnmodifiableList() {
		unModifiableList.add("b");
	}

	@Test
	public void testUnmodifiableListChangesThroughReferenceToModifiableList() {
		modifiableList.add("b");
		assertEquals(2, modifiableList.size());
		assertEquals(2, unModifiableList.size());

		modifiableList.add("c");
		assertEquals(3, modifiableList.size());
		assertEquals(3, unModifiableList.size());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testAddToImmutableList() {
		immutableList.add("b");
	}

	@Test
	public void testList() {
		modifiableList.add("b");
		modifiableList.add("c");

		assertEquals(3, modifiableList.size());
		assertEquals(1, immutableList.size());
	}

}
