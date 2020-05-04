package by.training.epam.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.training.epam.bean.Order;
import by.training.epam.dao.DAOException;
import by.training.epam.dao.OrderDAO;

public class OrderSax implements OrderDAO {
	
	private static final String XML_PATH = "resources/orders.xml";

	@Override
	public List<Order> getOrders() throws DAOException {
		List<Order> orders = null;
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			OrderSaxHandler handler = new OrderSaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(XML_PATH));
			orders = handler.getOrders();
		} catch (SAXException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new DAOException(e);
			
		}
		return orders;
	}

}
