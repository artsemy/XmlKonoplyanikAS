package by.training.epam.dao;

import by.training.epam.dao.impl.OrderDom;
import by.training.epam.dao.impl.OrderSax;
import by.training.epam.dao.impl.OrderStax;

public class DAOFactory {
	
	private static DAOFactory instance;
	
	OrderDom orderDom;
	OrderSax orderSax;
	OrderStax orderStax;
	
	private DAOFactory () {
		orderDom = new OrderDom();
		orderSax = new OrderSax();
		orderStax = new OrderStax();
	}
	
	public static synchronized DAOFactory getInstance() throws DAOException  {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	public OrderDAO getDom() {
		return orderDom;
	}
	
	public OrderDAO getSax() {
		return orderSax;
	}
	
	public OrderDAO getStax() {
		return orderStax;
	}
	
}
