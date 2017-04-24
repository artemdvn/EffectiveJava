package effectivejava.chapter1.article1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaticFactoryMethod {

	public static void main(String[] args) {

		// Factory methods are static methods that return an instance of the
		// native class. Examples in the JDK:
		// LogManager lm = LogManager.getLogManager();
		// Pattern.compile
		//Collections.unmodifiableCollection(c)unmodifiableCollection, Collections.synchronizeCollection
		//Arrays.asList(a)
		// Calendar.getInstance
		// DriverManager.getConnection(url)

		System.out.println(new Boolean(false));
		System.out.println(valueOf(false));

		System.out.println("--------------------------------");
		System.out.println("The following example will check if a text contains a number with 3 digits");
		System.out.println("0: " + testPattern("0"));
		System.out.println("1233: " + testPattern("1233"));
		System.out.println("29 Kasdkf 2300 Kdsdf: " + testPattern("29 Kasdkf 2300 Kdsdf"));
		System.out.println("99900234: " + testPattern("99900234"));		
		
	}

	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}

	//The following example will check if a text contains a number with 3 digits.
	public static boolean testPattern(String s) {
		Pattern pattern = Pattern.compile("\\d{3}");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

}
