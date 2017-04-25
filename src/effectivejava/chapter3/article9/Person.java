package effectivejava.chapter3.article9;

/**
 * A class of person to show classic hashCode.
 * 
 * @author Artem Dvornichenko  
 * @since 2017-04-25
 */
public class Person {
	
	private String name;
	private int age;
	private boolean isAlive;
	private PhoneNumber phone;
	private float temperature;
		
	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age, boolean isAlive, PhoneNumber phone, float temperature) {
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
		this.phone = phone;
		this.temperature = temperature;
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (isAlive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + Float.floatToIntBits(temperature);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;

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
		if (isAlive != other.isAlive) {
			return false;
		}

		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}

		if (Float.floatToIntBits(temperature) != Float.floatToIntBits(other.temperature)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isAlive=" + isAlive + ", phone=" + phone + ", temperature="
				+ temperature + "]";
	}

}
