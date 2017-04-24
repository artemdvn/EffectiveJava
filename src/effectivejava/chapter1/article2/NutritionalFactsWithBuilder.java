package effectivejava.chapter1.article2;

public class NutritionalFactsWithBuilder {
	private int sodium;
	private int fat;
	private int carbo;

	public static class Builder {
		private int sodium;
		private int fat;
		private int carbo;

		public Builder(int s) {
			this.sodium = s;
		}

		public Builder fat(int f) {
			this.fat = f;
			return this;
		}

		public Builder carbo(int c) {
			this.carbo = c;
			return this;
		}

		public NutritionalFactsWithBuilder build() {
			return new NutritionalFactsWithBuilder(this);
		}
	}

	private NutritionalFactsWithBuilder(Builder b) {
		this.sodium = b.sodium;
		this.fat = b.fat;
		this.carbo = b.carbo;
	}
}
