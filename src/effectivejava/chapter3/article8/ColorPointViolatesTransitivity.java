package effectivejava.chapter3.article8;

/**
 * A class of color point to show violation of transitivity.
 * 
 * @author Artem Dvornichenko  
 * @since 2017-04-24
 */
public class ColorPointViolatesTransitivity extends Point {
	private final Color color;

	public ColorPointViolatesTransitivity(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// Broken - violates transitivity!
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point))
			return false;

		// If o is a normal Point, do a color-blind comparison
		if (!(o instanceof ColorPointViolatesTransitivity))
			return o.equals(this);

		// o is a ColorPoint; do a full comparison
		return super.equals(o) && ((ColorPointViolatesTransitivity) o).color == color;
	}

}
