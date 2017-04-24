package effectivejava.chapter3.article8;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPointViolatesLiskov extends PointViolatesLiskov {
	private static final AtomicInteger counter = new AtomicInteger();

	public CounterPointViolatesLiskov(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}

	public int numberCreated() {
		return counter.get();
	}
}
