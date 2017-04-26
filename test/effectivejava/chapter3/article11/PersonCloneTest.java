package effectivejava.chapter3.article11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonCloneTest {
	
	private ExtendedPerson p1;
	private ExtendedPerson p2;
	private ExtendedPerson p3;
	
	@Before
	public void setUp() {
		p1 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		p2 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		p3 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f);		
	}	
	
	@Test
	public void testExtendedPerson() {
		assertTrue(p1.equals(p2) == (p1.hashCode() == p2.hashCode()));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
		
		p3.setPhone(new PhoneNumber(111, 222, 333));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
		
	}
	
	@Test
	public void testExtendedPersonClone() {
		ExtendedPerson p1Clone = p1.clone();
		ExtendedPerson p2Clone = p2.clone();
		ExtendedPerson p3Clone = p3.clone();
		
		assertTrue(p1Clone != p1);
		assertTrue(p2Clone != p2);
		assertTrue(p3Clone != p3);		
		
		assertTrue(p1Clone.getClass() == p1.getClass());
		assertTrue(p2Clone.getClass() == p2.getClass());
		assertTrue(p3Clone.getClass() == p3.getClass());
		
		assertTrue(p1Clone.equals(p1));
		assertTrue(p2Clone.equals(p2));
		assertTrue(p3Clone.equals(p3));
				
		assertTrue(p1Clone.equals(p2Clone) == (p1Clone.hashCode() == p2Clone.hashCode()));
		assertTrue(p1Clone.equals(p3Clone) == (p1Clone.hashCode() == p3Clone.hashCode()));
		
		p3Clone.setPhone(new PhoneNumber(111, 222, 333));
		assertTrue(p1Clone.equals(p3Clone) == (p1Clone.hashCode() == p3Clone.hashCode()));
		
	}

}
