package effectivejava.chapter1.article5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonIsBabyBoomer {

	public static void main(String[] args) {

		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1999, Calendar.JANUARY, 1, 0, 0, 0);

		
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			WrongPerson wp = new WrongPerson(gmtCal.getTime());
			wp.isBabyBoomer();
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);

		
		
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			RightPerson rp = new RightPerson(gmtCal.getTime());
			rp.isBabyBoomer();
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);

	}

}

class WrongPerson {
	private final Date birthDate;

	public WrongPerson(Date birthDate) {
		super();
		this.birthDate = birthDate;
	}

	// DON'T DO THIS!
	public boolean isBabyBoomer() {
		// Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}

}

class RightPerson {
	private final Date birthDate;

	public RightPerson(Date birthDate) {
		super();
		this.birthDate = birthDate;
	}

	/**
	 * The starting and ending dates of the baby boom.
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	public boolean isBabyBoomer() {
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}
}
