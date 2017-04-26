package effectivejava.chapter3.article11;

import java.util.Objects;

/**
 * A helper class of order.
 * 
 * @author Artem Dvornichenko
 * @since 2017-04-26
 */
public class Order {
	
	private int number;

	public Order(int number) {
		this.number = number;
	}	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Order deepCopy(){
		return new Order(number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + "]";
	}	

}
