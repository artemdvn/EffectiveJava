package effectivejava.chapter1.article1;

import java.util.HashMap;
import java.util.Map;

public class FlyweightOperationTest {

	public static void main(String[] args) {

		FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

		for (int i = 3; i < 10; i++) {
			Flyweight flyweightAdder = flyweightFactory.getFlyweight(OperationType.ADDING);
			flyweightAdder.doMath(i, i);

			Flyweight flyweightMultiplier = flyweightFactory.getFlyweight(OperationType.MULTIPLYING);
			flyweightMultiplier.doMath(i, i);
		}
	}

}

interface Flyweight {

	public void doMath(int a, int b);

}

class FlyweightAdder implements Flyweight {

	OperationType operation;

	public FlyweightAdder() {
		operation = OperationType.ADDING;
	}

	@Override
	public void doMath(int a, int b) {
		System.out.println(operation + " " + a + " and " + b + ": " + (a + b));
	}

}

class FlyweightMultiplier implements Flyweight {

	OperationType operation;

	public FlyweightMultiplier() {
		operation = OperationType.MULTIPLYING;
	}

	@Override
	public void doMath(int a, int b) {
		System.out.println(operation + " " + a + " and " + b + ": " + (a * b));
	}

}

class FlyweightFactory {

	private static FlyweightFactory flyweightFactory;

	private Map<OperationType, Flyweight> flyweightPool;

	private FlyweightFactory() {
		flyweightPool = new HashMap<OperationType, Flyweight>();
	}

	public static FlyweightFactory getInstance() {
		if (flyweightFactory == null) {
			flyweightFactory = new FlyweightFactory();
		}
		return flyweightFactory;
	}

	public Flyweight getFlyweight(OperationType key) {
		if (flyweightPool.containsKey(key)) {
			return flyweightPool.get(key);
		} else {
			Flyweight flyweight = null;
			switch (key) {
			case ADDING: {
				flyweight = new FlyweightAdder();
				break;
			}
			case MULTIPLYING: {
				flyweight = new FlyweightMultiplier();
				break;
			}
			}
			flyweightPool.put(key, flyweight);
			return flyweight;
		}
	}

}

enum OperationType {
	ADDING, MULTIPLYING
}
