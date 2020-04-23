package by.training.epam.bean;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String user;
	private int price;
	private List<String> drinks;
	
	public Order() {}

	public Order(int id, String user, int price, List<String> drinks) {
		this.id = id;
		this.user = user;
		this.price = price;
		this.drinks = drinks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<String> drinks) {
		this.drinks = drinks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (drinks == null) {
			if (other.drinks != null)
				return false;
		} else if (!drinks.equals(other.drinks))
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", price=" + price + ", drinks=" + drinks + "]";
	}

}
