package by.training.epam.service.impl;

import java.util.List;

import by.training.epam.bean.Order;
import by.training.epam.dao.DAOException;
import by.training.epam.dao.DAOFactory;
import by.training.epam.dao.OrderDAO;
import by.training.epam.service.MyValidator;
import by.training.epam.service.OrderService;
import by.training.epam.service.ServiceConstant;
import by.training.epam.service.ServiceException;

public class OrderParceStax implements OrderService{

	@Override
	public List<Order> parce() throws ServiceException {
		List<Order> orders;
		try {
			valid();
			DAOFactory factory = DAOFactory.getInstance();
			OrderDAO dao = factory.getStax();
			orders = dao.getOrders();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return orders;
	}
	
	private void valid() throws DAOException {
		MyValidator validator = new MyValidator();
		boolean b = validator.validate(ServiceConstant.XSD_PATH, ServiceConstant.XML_PATH);
		if (!b) {
			throw new DAOException();
		}
	}

}
