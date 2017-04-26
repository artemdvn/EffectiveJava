package effectivejava.chapter3.article11;

import java.util.Objects;

/**
 * A class of base person to show clone().
 * 
 * @author Artem Dvornichenko
 * @since 2017-04-26
 */
public class BasePerson implements Cloneable {

	protected String name;
	protected int age;

	public BasePerson(String name) {
		this.name = name;
	}

	public BasePerson(String name, int age) {
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
	
	public String ageToString() {
		return new Integer(age).toString();
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
		BasePerson other = (BasePerson) obj;

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
		return "Base Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public BasePerson clone() {
		try {
			System.out.println(ageToString());
			return (BasePerson) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
	}

}
