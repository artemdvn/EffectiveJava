package effectivejava.chapter3.article8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestColorPoint {
	
	private Point p;
	
	@Before
	public void setUp() {
		p = new Point(1, 2);		
	}
	
	@Test
	public void testColorPointViolatesSymmetry() {
		ColorPointViolatesSymmetry cp = new ColorPointViolatesSymmetry(1, 2, Color.RED);
		
		assertTrue(p.equals(cp));		
		assertFalse(cp.equals(p));
	}
	
	@Test
	public void testColorPointDoNotViolatesTransitivity() {
		ColorPointViolatesSymmetry cp1 = new ColorPointViolatesSymmetry(1, 2, Color.RED);
		ColorPointViolatesSymmetry cp2 = new ColorPointViolatesSymmetry(1, 2, Color.BLUE);
		
		assertFalse(cp1.equals(p));		
		assertTrue(p.equals(cp2));
		assertFalse(cp1.equals(cp2));
	}
	
	@Test
	public void testColorPointDoNotViolatesSymmetry() {
		ColorPointViolatesTransitivity cp = new ColorPointViolatesTransitivity(1, 2, Color.RED);
		
		assertTrue(p.equals(cp));		
		assertTrue(cp.equals(p));
	}
	
	@Test
	public void testColorPointViolatesTransitivity() {
		ColorPointViolatesTransitivity cp1 = new ColorPointViolatesTransitivity(1, 2, Color.RED);
		ColorPointViolatesTransitivity cp2 = new ColorPointViolatesTransitivity(1, 2, Color.BLUE);
		
		assertTrue(cp1.equals(p));		
		assertTrue(p.equals(cp2));
		assertFalse(cp1.equals(cp2));
	}

}
