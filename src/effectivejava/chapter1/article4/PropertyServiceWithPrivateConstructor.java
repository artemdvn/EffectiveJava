package effectivejava.chapter1.article4;

import java.util.ResourceBundle;

/**
 * A service for creating new message box dialogs to inform or warn the user.
 */
public class PropertyServiceWithPrivateConstructor {

	private PropertyServiceWithPrivateConstructor() {
		throw new AssertionError();
	}

	/**
	 * Returns menu property value from resource bundle.
	 * 
	 * @param propertyName
	 *            the name of the property in .properties file
	 */
	public static String getPropertyValue(String propertyName) {
		ResourceBundle rb = ResourceBundle.getBundle("effectivejava.chapter1.article4.test");
		return rb.getString(propertyName);
	}

	public static void main(String[] args) {
		// PropertyServiceWithPrivateConstructor ps = new
		// PropertyServiceWithPrivateConstructor(); //java.lang.AssertionError
		System.out.println(PropertyServiceWithPrivateConstructor.getPropertyValue("TEST"));
		new B(1);
	}

}

class A {
	public A(int i) {

	}
}

class B extends A {
	public B(int i) {
		super(i);
	}
}