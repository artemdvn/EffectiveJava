package effectivejava.chapter3.article11;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonCloneTest {
	
	private ExtendedPerson p1;
	private ExtendedPerson p2;
	private ExtendedPerson p3;
	private List<Order> orders1;
	private List<Order> orders2;
	private ExtendedPersonWithDeepCopy extendedPersonWithDeepCopy;
	
	@Before
	public void setUp() {
		orders1 = new ArrayList<>();
		orders1.add(new Order(1));
		orders1.add(new Order(2));
		
		orders2 = new ArrayList<>();
		orders2.add(new Order(5));
		
		p1 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f, orders1);
		p2 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f, orders1);
		p3 = new ExtendedPerson("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f, orders2);		
		
		extendedPersonWithDeepCopy = new ExtendedPersonWithDeepCopy("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f, orders2);
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
		
	}
	
	@Test
	public void testExtendedPersonWithoutDeepCopy() {
		ExtendedPerson p1Clone = p1.clone();
		
		assertTrue(p1.getOrders().equals(p1Clone.getOrders()));
		p1.getOrders().add(new Order(22));
		assertTrue(p1.getOrders().equals(p1Clone.getOrders()));		
	}
	
	@Test
	public void testExtendedPersonWithDeepCopy() {
		ExtendedPersonWithDeepCopy clone = extendedPersonWithDeepCopy.clone();
		
		assertTrue(extendedPersonWithDeepCopy.getOrders().equals(clone.getOrders()));
		extendedPersonWithDeepCopy.getOrders().add(new Order(22));
		assertFalse(extendedPersonWithDeepCopy.getOrders().equals(clone.getOrders()));
		
		System.out.println(extendedPersonWithDeepCopy.getIntArray());
		System.out.println(clone.getIntArray());
		assertTrue(extendedPersonWithDeepCopy.getIntArray() == clone.getIntArray());
	}
	
	@Test
	public void testOverridedMethodWithNPE() {
		ExtendedPerson person = new ExtendedPerson("Test person");
		
		boolean NPEThrown = false;
		try {
			person.clone();
		} catch (RuntimeException e) {
			NPEThrown = true;
		}
		assertTrue(NPEThrown);
	}

}
