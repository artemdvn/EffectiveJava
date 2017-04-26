package effectivejava.chapter3.article11;

import java.util.Objects;

/**
 * A class of base person to show wrong usage of clone() without implementing Cloneable.
 * 
 * @author Artem Dvornichenko
 * @since 2017-04-26
 */
public class NonCloneableBasePerson {

	protected String name;
	protected int age;

	public NonCloneableBasePerson(String name) {
		this.name = name;
	}

	public NonCloneableBasePerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonCloneableBasePerson other = (NonCloneableBasePerson) obj;

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (age != other.age) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "NonCloneable Base Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public NonCloneableBasePerson clone() {
		try {
			return (NonCloneableBasePerson) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
	}

}
