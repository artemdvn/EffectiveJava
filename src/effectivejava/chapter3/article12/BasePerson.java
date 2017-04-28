package effectivejava.chapter3.article12;

import java.util.Objects;

/**
 * A class of base person to show compareTo().
 * 
 * @author Artem Dvornichenko
 * @since 2017-04-27
 */
public class BasePerson {

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

	public int compareTo(BasePerson person) {
		// Compare names
		if (name.compareTo(person.name) < 0) {
			return -1;
		}
		if (name.compareTo(person.name) > 0) {
			return 1;
		}

		// Names are equal, compare age
		if (age < person.age) {
			return -1;
		}
		if (age > person.age) {
			return 1;
		}

		return 0; // All fields are equal
	}

}
