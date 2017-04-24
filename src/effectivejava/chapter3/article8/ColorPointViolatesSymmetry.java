package effectivejava.chapter3.article8;

public class ColorPointViolatesSymmetry extends Point {
	private final Color color;

	public ColorPointViolatesSymmetry(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// Broken - violates symmetry!
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPointViolatesSymmetry))
			return false;
		return super.equals(o) && ((ColorPointViolatesSymmetry) o).color == color;
	}

}
