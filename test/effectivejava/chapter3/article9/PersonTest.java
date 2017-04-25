package effectivejava.chapter3.article9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testPerson() {
		Person p1 = new Person("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		Person p2 = new Person("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		Person p3 = new Person("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f);
		
		assertTrue(p1.equals(p2) == (p1.hashCode() == p2.hashCode()));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
		
		p3.setPhone(new PhoneNumber(111, 222, 333));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
	}
	
	@Test
	public void testImmutablePerson() {
		ImmutablePerson p1 = new ImmutablePerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		ImmutablePerson p2 = new ImmutablePerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		ImmutablePerson p3 = new ImmutablePerson("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f);
		
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));		
	}
	
	@Test
	public void testAdvancedPerson() {
		AdvancedPerson p1 = new AdvancedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		AdvancedPerson p2 = new AdvancedPerson("Alex", 12, true, new PhoneNumber(111, 222, 333), 35.5f);
		AdvancedPerson p3 = new AdvancedPerson("Alex", 12, true, new PhoneNumber(555, 666, 777), 35.5f);
		
		assertTrue(p1.equals(p2) == (p1.hashCode() == p2.hashCode()));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
		
		p3.setPhone(new PhoneNumber(111, 222, 333));
		assertTrue(p1.equals(p3) == (p1.hashCode() == p3.hashCode()));
	}

}
