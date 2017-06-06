package effectivejava.chapter4.article16;

/**
 * A class shows SELF problem of wrapper classes.
 */
public class Wrapper implements SomethingWithCallback {

	private final WrappedObject wrappedObject;

	Wrapper(WrappedObject wrappedObject) {
		this.wrappedObject = wrappedObject;
	}

	@Override
	public void doSomething() {
		wrappedObject.doSomething();
	}

	void doSomethingElse() {
		System.out.println("We can do everything the wrapped object can, and more!");
	}

	@Override
	public void call() {
		System.out.println("Wrapper callback!");
	}

	public static void main(String[] args) {
		SomeService service = new SomeService();
		WrappedObject wrappedObject = new WrappedObject(service);
		Wrapper wrapper = new Wrapper(wrappedObject);

		// The problem is that even though we called doSomething() on the wrapper, 
		// the callback of the wrapped object got called, not the callback of the wrapper. 
		// This is what Joshua Bloch refers to when he says that "callbacks elude the wrapper".
		wrapper.doSomething();
	}
}
