package effectivejava.chapter3.article8;

/**
 * A class of color point to show the right usage of composition instead of inheritance.
 * 
 * @author Artem Dvornichenko  
 * @since 2017-04-24
 */
public class ColorPointWithComposition {
	private final Color color;
	private final Point point;
	
	public ColorPointWithComposition(int x, int y, Color color) {
		if (color == null)
			throw new NullPointerException();
		point = new Point(x, y);
		this.color = color;
	}

	/**
	 * Returns the point-view of this color point.
	 */
	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPointWithComposition))
			return false;
		ColorPointWithComposition cp = (ColorPointWithComposition) o;
		return cp.point.equals(point) && cp.color.equals(color);
	}

	@Override
	public int hashCode() {
		return point.hashCode() * 33 + color.hashCode();
	}

}
