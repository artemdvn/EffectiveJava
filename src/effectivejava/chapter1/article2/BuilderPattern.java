package effectivejava.chapter1.article2;

public class BuilderPattern {

	public static void main(String args[]) {
		// telescoping constructor, does not scale well
		NutritionalFactsWithTelescopingConstructor cocaCola = new NutritionalFactsWithTelescopingConstructor(240, 8);
		
		//JavaBeans, allows inconsistency, mandates mutability
		NutritionalFactsWithJavaBeans cocaCola1 = new NutritionalFactsWithJavaBeans();
		cocaCola1.setCarbo(240);
		cocaCola1.setFat(8);
		
		NutritionalFactsWithBuilder n = new NutritionalFactsWithBuilder.Builder(10).carbo(23).fat(1).build();
	}

}
