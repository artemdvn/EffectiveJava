package effectivejava.chapter3.article11;

import java.util.Objects;

/**
 * A class of extended person to show clone().
 * 
 * @author Artem Dvornichenko
 * @since 2017-04-26
 */
public class ExtendedPerson extends BasePerson {

	private boolean isAlive;
	private PhoneNumber phone;
	private float temperature;

	public ExtendedPerson(String name) {
		super(name);
	}

	public ExtendedPerson(String name, int age, boolean isAlive, PhoneNumber phone, float temperature) {
		super(name, age);
		this.isAlive = isAlive;
		this.phone = phone;
		this.temperature = temperature;
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
		return Objects.hash(name, age, isAlive, phone, temperature);
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		ExtendedPerson other = (ExtendedPerson) obj;

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
		return "Extended Person [name=" + name + ", age=" + age + ", isAlive=" + isAlive + ", phone=" + phone
				+ ", temperature=" + temperature + "]";
	}
	
	@Override
	public ExtendedPerson clone() {
		return (ExtendedPerson) super.clone();
	}

}
