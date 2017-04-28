package effectivejava.chapter3.article12;

import java.util.Comparator;

public class LineNumberComparator implements Comparator<PhoneNumber> {

	@Override
	public int compare(PhoneNumber o1, PhoneNumber o2) {
		if (o1.getLineNumber() < o2.getLineNumber()) {
			return -1;
		}
		if (o1.getLineNumber() > o2.getLineNumber()) {
			return 1;
		}
		return 0;
	}	

}
