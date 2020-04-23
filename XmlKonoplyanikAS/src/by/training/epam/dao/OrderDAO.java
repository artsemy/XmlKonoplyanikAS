package by.training.epam.dao;

import java.util.List;

import by.training.epam.bean.Order;
import by.training.epam.service.ServiceException;

public interface OrderDAO {
	
	public List<Order> readOrders() throws DAOException;
	
}
