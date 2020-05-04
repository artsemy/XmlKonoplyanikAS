package by.training.epam.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import by.training.epam.bean.Order;
import by.training.epam.dao.DAOException;
import by.training.epam.dao.OrderDAO;

public class OrderDom implements OrderDAO {

	private static final String XML_PATH = "resources/orders.xml";
	private static final String ATTRIBUTE_ID = "id";
	private static final String ORDER_TAG = "order";
	private static final String USER_TAG = "user";
	private static final String DRINK_LIST_TAG = "drink_list";
	private static final String DRINK_TAG = "drink";
	private static final String PRICE_TAG = "price";
	
	@Override
	public List<Order> getOrders() throws DAOException {
		List<Order> orders = new ArrayList<Order>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(XML_PATH));
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName(ORDER_TAG);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node orderNode = nodeList.item(i);
				Order order = buildOrder(orderNode);
				orders.add(order);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new DAOException(e);
		}
		return orders;
	}
	
	private Order buildOrder(Node orderNode) {
		Order order = new Order();
		Element orderElement = (Element) orderNode;
		order.setId(Integer.parseInt(orderElement.getAttribute(ATTRIBUTE_ID)));
		order.setUser(orderElement.getElementsByTagName(USER_TAG).item(0).getTextContent());
		Element drinkListElement = (Element) orderElement.getElementsByTagName(DRINK_LIST_TAG).item(0);
		NodeList drinkList = drinkListElement.getElementsByTagName(DRINK_TAG);
		List<String> drinks = new ArrayList<String>();
		for (int j = 0; j < drinkList.getLength(); j++) {
			Node drinkNode = drinkList.item(j);
			Element drinkElement = (Element) drinkNode;
			String st = drinkElement.getTextContent();
			drinks.add(st);
		}
		order.setDrinks(drinks);
		order.setPrice(Integer.parseInt(orderElement.getElementsByTagName(PRICE_TAG).item(0).getTextContent()));
		return order;
	}

}
