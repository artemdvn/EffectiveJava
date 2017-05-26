package effectivejava.chapter4.article17;

public class Super {
	// Broken - constructor invokes an overridable method
	public Super() {
		overrideMe();
	}

	public void overrideMe() {
	}
}
