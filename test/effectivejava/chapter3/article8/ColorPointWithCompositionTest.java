package effectivejava.chapter3.article8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorPointWithCompositionTest {
	
	private Point p;
	
	@Before
	public void setUp() {
		p = new Point(1, 2);		
	}
	
	@Test
	public void testSymmetryOfColorPointWithComposition() {
		ColorPointWithComposition cp = new ColorPointWithComposition(1, 2, Color.RED);
		
		assertTrue(p.equals(cp) == cp.equals(p));
	}
	
	@Test
	public void testTransitivityOfColorPointWithComposition() {
		ColorPointWithComposition cp1 = new ColorPointWithComposition(1, 2, Color.RED);
		ColorPointWithComposition cp2 = new ColorPointWithComposition(1, 2, Color.RED);
		ColorPointWithComposition cp3 = new ColorPointWithComposition(1, 2, Color.RED);
		
		assertTrue(cp1.equals(cp2));		
		assertTrue(cp1.equals(cp3));
		assertTrue(cp2.equals(cp3));
	}	

}
