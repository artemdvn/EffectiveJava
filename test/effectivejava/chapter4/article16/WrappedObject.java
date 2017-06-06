package effectivejava.chapter4.article16;

public class WrappedObject implements SomethingWithCallback {

	private final SomeService service;

	WrappedObject(SomeService service) {
		this.service = service;
	}

	@Override
	public void doSomething() {
		service.performAsync(this);
	}

	@Override
	public void call() {
		System.out.println("WrappedObject callback!");
	}
}
