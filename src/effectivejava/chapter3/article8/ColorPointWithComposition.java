package effectivejava.chapter3.article8;

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
	
	public static void main(String[] args) {

		Point p = new Point(1, 2);
		ColorPointWithComposition cp = new ColorPointWithComposition(1, 2, Color.RED);
		System.out.println(p.equals(cp) + " " + cp.equals(p));

		ColorPointWithComposition p1 = new ColorPointWithComposition(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPointWithComposition p3 = new ColorPointWithComposition(1, 2, Color.RED);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
	}

}
