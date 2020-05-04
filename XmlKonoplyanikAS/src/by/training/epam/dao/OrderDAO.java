package by.training.epam.dao;

import java.util.List;

import by.training.epam.bean.Order;

public interface OrderDAO {
	
	public List<Order> getOrders() throws DAOException;
	
}
