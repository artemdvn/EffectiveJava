package effectivejava.chapter3.article8;

public class Parent implements Cloneable{

	protected void method(){}
	
	@Override
	protected Parent clone(){
		try {
			return (Parent) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
