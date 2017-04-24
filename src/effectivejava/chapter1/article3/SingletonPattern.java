package effectivejava.chapter1.article3;

public class SingletonPattern {

	public static void main(String args[]) {
		System.out.println(PropertyService.getInstance().getPropertyValue("TEST"));		
	}

}
