package effectivejava.chapter4.article16;

public final class SomeService {

	void performAsync(SomethingWithCallback callback) {
		new Thread(() -> {
			perform();
			callback.call();
		}).start();
	}

	void perform() {
		System.out.println("Service is being performed.");
	}
}
