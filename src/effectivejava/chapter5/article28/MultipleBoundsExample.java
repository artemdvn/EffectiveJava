package effectivejava.chapter5.article28;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Foo {
}

interface Bar {
}

class FooBar1 implements Foo, Bar {
	public String toString() {
		return "FooBar1";
	}
}

class FooBar2 implements Foo, Bar {
	public String toString() {
		return "FooBar2";
	}
}

public class MultipleBoundsExample {
	static <T extends Foo & Bar> T getFooBar1() {	
		return (T) new FooBar1();
	}

	static <T extends Foo & Bar> T getFooBar2() {
		return (T) new FooBar2();
	}

	static <T extends Foo & Bar> T getFooBar() {
		return (T) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[] { Foo.class, Bar.class },
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) {
						return "PROXY!!!";
					}
				});
	}

	static <U extends Foo & Bar> void show(U u) {
		System.out.println(u);
	}

	public static void main(String[] args) {
		show(getFooBar1());
		show(getFooBar2());
		show(getFooBar());
	}

}
