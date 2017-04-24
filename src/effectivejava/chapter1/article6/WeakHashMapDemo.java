package effectivejava.chapter1.article6;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		Map hashMap = new HashMap();
		Map weakHashMap = new WeakHashMap();

		String keyHashMap = new String("keyHashMap");
		String keyWeakHashMap = new String("keyWeakHashMap");

		hashMap.put(keyHashMap, "helloHash");
		weakHashMap.put(keyWeakHashMap, "helloWeakHash");
		System.out.println("Before gc: hash map value:" + hashMap.get("keyHashMap") + " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap"));

		keyHashMap = null;
		keyWeakHashMap = null;

		System.gc();

		System.out.println("After gc: hash map value:" + hashMap.get("keyHashMap") + " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap"));
	}
}
