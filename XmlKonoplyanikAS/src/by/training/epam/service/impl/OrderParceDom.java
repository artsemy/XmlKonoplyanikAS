package by.training.epam.service.impl;

import java.util.List;

import by.training.epam.bean.Order;
import by.training.epam.dao.DAOException;
import by.training.epam.dao.DAOFactory;
import by.training.epam.dao.OrderDAO;
import by.training.epam.service.OrderService;
import by.training.epam.service.ServiceException;

public class OrderParceDom implements OrderService {

	@Override
	public List<Order> parce() throws ServiceException {
		List<Order> orders;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			OrderDAO orderDAO = daoFactory.getDom();
			orders = orderDAO.readOrders();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return orders;
	}

}
