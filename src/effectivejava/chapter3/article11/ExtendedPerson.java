package effectivejava.chapter3.article11;

import java.util.List;
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
	private List<Order> orders;

	public ExtendedPerson(String name) {
		super(name);
	}

	public ExtendedPerson(String name, int age, boolean isAlive, PhoneNumber phone, float temperature, List<Order> orders) {
		super(name, age);
		this.isAlive = isAlive;
		this.phone = phone;
		this.temperature = temperature;
		this.orders = orders;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String ageToString() {
		return phone.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, isAlive, phone, temperature, orders);
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
		
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
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
