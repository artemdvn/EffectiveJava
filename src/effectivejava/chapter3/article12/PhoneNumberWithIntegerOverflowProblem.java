package effectivejava.chapter3.article12;

public final class PhoneNumberWithIntegerOverflowProblem implements Comparable<PhoneNumberWithIntegerOverflowProblem> {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public PhoneNumberWithIntegerOverflowProblem(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumberWithIntegerOverflowProblem))
			return false;
		PhoneNumberWithIntegerOverflowProblem pn = (PhoneNumberWithIntegerOverflowProblem) o;
		return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}

	/**
	 * Returns the string representation of this phone number. The string
	 * consists of fourteen characters whose format is "(XXX) YYY-ZZZZ", where
	 * XXX is the area code, YYY is the prefix, and ZZZZ is the line number.
	 * (Each of the capital letters represents a single decimal digit.)
	 * 
	 * If any of the three parts of this phone number is too small to fill up
	 * its field, the field is padded with leading zeros. For example, if the
	 * value of the line number is 123, the last four characters of the string
	 * representation will be "0123".
	 * 
	 * Note that there is a single space separating the closing parenthesis
	 * after the area code from the first digit of the prefix.
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	public int compareTo(PhoneNumberWithIntegerOverflowProblem pn) {
		// Compare area codes
		int areaCodeDiff = areaCode - pn.areaCode;
		if (areaCodeDiff != 0)
			return areaCodeDiff;

		// Area codes are equal, compare prefixes
		int prefixDiff = prefix - pn.prefix;
		if (prefixDiff != 0)
			return prefixDiff;

		// Area codes and prefixes are equal, compare line numbers
		return lineNumber - pn.lineNumber;
	}

}
