package effectivejava.chapter3.article8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorPointTest {
	
	private Point p;
	
	@Before
	public void setUp() {
		p = new Point(1, 2);		
	}
	
	@Test
	public void testSymmetryOfColorPointViolatesSymmetry() {
		ColorPointViolatesSymmetry cp = new ColorPointViolatesSymmetry(1, 2, Color.RED);
		
		assertFalse(p.equals(cp) == cp.equals(p));		
//		assertTrue(cp.equals(p));
	}
	
	@Test
	public void testTransitivityOfColorPointViolatesSymmetry() {
		ColorPointViolatesSymmetry cp1 = new ColorPointViolatesSymmetry(1, 2, Color.RED);
		ColorPointViolatesSymmetry cp2 = new ColorPointViolatesSymmetry(1, 2, Color.RED);
		
		assertTrue(cp1.equals(cp2));
		assertTrue(p.equals(cp2));
		assertFalse(cp1.equals(p));		
		
		
	}
	
	@Test
	public void testSymmetryOfColorPointViolatesTransitivity() {
		ColorPointViolatesTransitivity cp = new ColorPointViolatesTransitivity(1, 2, Color.RED);
		
		assertTrue(p.equals(cp));		
		assertTrue(cp.equals(p));
	}
	
	@Test
	public void testTransitivityOfColorPointViolatesTransitivity() {
		ColorPointViolatesTransitivity cp1 = new ColorPointViolatesTransitivity(1, 2, Color.RED);
		ColorPointViolatesTransitivity cp2 = new ColorPointViolatesTransitivity(1, 2, Color.BLUE);		
				
		assertTrue(p.equals(cp2));
		assertTrue(cp1.equals(p));
		assertFalse(cp1.equals(cp2));
	}

}
