package effectivejava.chapter3.article9;

/**
 * A class of immutable person to show lazily initialized, cached hashCode.
 * 
 * @author Artem Dvornichenko  
 * @since 2017-04-25
 */
public class ImmutablePerson {
	
	private String name;
	private int age;
	private boolean isAlive;
	private PhoneNumber phone;
	private float temperature;
	private volatile int hashCode;
		
	public ImmutablePerson(String name, int age, boolean isAlive, PhoneNumber phone, float temperature) {
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

	public boolean isAlive() {
		return isAlive;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public float getTemperature() {
		return temperature;
	}

	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			final int prime = 31;
			result = 1;
			result = prime * result + age;
			result = prime * result + (isAlive ? 1231 : 1237);
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + Float.floatToIntBits(temperature);
			hashCode = result;
		}
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
		ImmutablePerson other = (ImmutablePerson) obj;

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
		return "Immutable person [name=" + name + ", age=" + age + ", isAlive=" + isAlive + ", phone=" + phone + ", temperature="
				+ temperature + "]";
	}	

}
