package effectivejava.chapter3.article8;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CounterPointTest {

	private Set<Point> unitCircle;
	private Set<PointViolatesLiskov> unitCircleViolatesLiskov;

	@Test
	public void testCounterPointDoNotViolatesLiskov() {
		unitCircle = new HashSet<>();
		unitCircle.add(new Point(1, 0));
		unitCircle.add(new Point(0, 1));
		unitCircle.add(new Point(-1, 0));
		unitCircle.add(new Point(0, -1));

		Point p = new Point(1, 0);
		Point cp = new CounterPoint(1, 0);

		assertTrue(unitCircle.contains(p));
		assertTrue(unitCircle.contains(cp));
	}

	@Test
	public void testCounterPointViolatesLiskov() {
		unitCircleViolatesLiskov = new HashSet<>();
		unitCircleViolatesLiskov.add(new PointViolatesLiskov(1, 0));
		unitCircleViolatesLiskov.add(new PointViolatesLiskov(0, 1));
		unitCircleViolatesLiskov.add(new PointViolatesLiskov(-1, 0));
		unitCircleViolatesLiskov.add(new PointViolatesLiskov(0, -1));

		PointViolatesLiskov p = new PointViolatesLiskov(1, 0);
		PointViolatesLiskov cp = new CounterPointViolatesLiskov(1, 0);

		assertTrue(unitCircleViolatesLiskov.contains(p));
		assertFalse(unitCircleViolatesLiskov.contains(cp));
	}

}
