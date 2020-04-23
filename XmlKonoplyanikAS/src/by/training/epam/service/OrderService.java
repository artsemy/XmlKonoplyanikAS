package by.training.epam.service;

import java.util.List;

import by.training.epam.bean.Order;

public interface OrderService {
	
	public List<Order> parce() throws ServiceException;
	
}
