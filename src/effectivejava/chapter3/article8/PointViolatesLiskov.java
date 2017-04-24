package effectivejava.chapter3.article8;

/**
 * A class of point to show violation of Liskov substitution principle.
 * 
 * @author Artem Dvornichenko  
 * @since 2017-04-24
 */
public class PointViolatesLiskov {
	private final int x;
	private final int y;

	public PointViolatesLiskov(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		PointViolatesLiskov p = (PointViolatesLiskov) o;
		return p.x == x && p.y == y;
	}

	@Override
	public int hashCode() {
		return 31 * x + y;
	}
}
