package effectivejava.chapter3.article11;

import org.eclipse.swt.widgets.Display;
import org.junit.Test;

public class SyncAsyncTest {
	
	private static Display display = Display.getDefault();
	
	@Test
	public void testAsyncExec() {
		display.asyncExec(() -> System.out.println("Inside Async"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Outside Async");
	}
	
	@Test
	public void testSyncExec() {
		Display.getDefault().syncExec(() -> System.out.println("Inside Sync"));	
		System.out.println("Outside Sync");
	}

}
