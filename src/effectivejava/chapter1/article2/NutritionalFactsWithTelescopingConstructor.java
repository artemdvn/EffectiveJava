package effectivejava.chapter1.article2;

public class NutritionalFactsWithTelescopingConstructor {
	private int sodium;
	private int fat;
	private int carbo;
	
	public NutritionalFactsWithTelescopingConstructor(int sodium) {
		this(sodium, 0);
	}

	public NutritionalFactsWithTelescopingConstructor(int sodium, int fat) {
		this(sodium, fat, 0);
	}
	
	public NutritionalFactsWithTelescopingConstructor(int sodium, int fat, int carbo) {
		this.sodium = sodium;
		this.fat = fat;
		this.carbo = carbo;
	}
}
