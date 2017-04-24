package effectivejava.chapter1.article5;

public class VerySlowProgram {

	public static void main(String[] args) {

		// very slow program because autoboxing is used
		long startTime = System.currentTimeMillis();
		System.out.println("Slow sum = " + getSlowSum());
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Slow sum elapsed time = " + elapsedTime);

		// fast program without autoboxing
		startTime = System.currentTimeMillis();
		System.out.println("Fast sum = " + getFastSum());
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;		
		System.out.println("Fast sum elapsed time = " + elapsedTime);

	}

	private static Long getSlowSum() {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		return sum;
	}
	
	private static long getFastSum() {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		return sum;
	}

}
