package effectivejava.chapter3.article8;

import java.util.Arrays;

public class IntegerArray {

	private int[] values;

	public IntegerArray(int[] values) {
		this.values = values;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IntegerArray other = (IntegerArray) obj;
		if (!Arrays.equals(values, other.values)) {
			return false;
		}
		return true;

	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(values);
	}
}
