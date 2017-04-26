package effectivejava.chapter3.article11;

import effectivejava.chapter3.article8.Parent;

public class CloneTest {

	public static void main(String[] args) {
		Child child = new Child();
		child.clone();

		// we cannot use methods from Parent
		// child.method(); //ERROR!
	}

}

class Child extends Parent {
	private void testMethod() {
		// we can use methods from Parent inside Child class
		method();
	}

	@Override
	protected Child clone() {
		return (Child) super.clone();
	}
}