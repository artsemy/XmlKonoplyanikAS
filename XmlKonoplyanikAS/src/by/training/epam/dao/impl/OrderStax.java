package by.training.epam.dao.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.training.epam.bean.Order;
import by.training.epam.dao.DAOException;
import by.training.epam.dao.OrderDAO;
import by.training.epam.dao.OrderTagName;

public class OrderStax implements OrderDAO {
	
	private static final String XML_PATH = "resources/orders.xml";

	@Override
	public List<Order> readOrders() throws DAOException {
		List<Order> orders;
		try {
			StringReader stringReader = new StringReader(XML_PATH);
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLStreamReader reader = inputFactory.createXMLStreamReader(stringReader);
			orders = buildOrders(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return orders;
	}
	
	private List<Order> buildOrders(XMLStreamReader reader) throws XMLStreamException {
		Order order = null;
		List<String> drinks = null;
		OrderTagName tag = OrderTagName.ORDER_LIST;
		List<Order> orders = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case Constants.START_ELEMENT:
				startElement(tag, order, drinks, reader);
				break;
			case Constants.CHARACTERS:
				characters(tag, order, drinks, reader);
				break;
			case Constants.END_ELEMENT:
				endElement(tag, order, drinks, reader, orders);
				break;
			}
		}
		return orders;
	}
	
	private void startElement(OrderTagName tag, Order order, List<String> drinks, XMLStreamReader reader) {
		tag = OrderTagName.valueOf(reader.getLocalName().toUpperCase());
		switch (tag) {
		case ORDER:
			order = new Order();
			order.setId(Integer.parseInt(reader.getAttributeValue(1)));
			break;
		case DRINK_LIST:
			drinks = new ArrayList<String>();
			break;
		default:
			break;
		}
	}
	
	private void endElement(OrderTagName tag, Order order, List<String> drinks, XMLStreamReader reader, List<Order> orders) {
		tag = OrderTagName.valueOf(reader.getLocalName().toUpperCase());
		switch (tag) {
		case DRINK_LIST:
			order.setDrinks(drinks);
			break;
		case ORDER:
			orders.add(order);
			break;
		default:
			break;
		}
		tag = OrderTagName.DRINK_LIST; //bad
	}
	
	private void characters(OrderTagName tag, Order order, List<String> drinks, XMLStreamReader reader) {
		String text = reader.getText();
		switch (tag) {
		case USER:
			order.setUser(text);
			break;
		case DRINK:
			drinks.add(text);
			break;
		case PRICE:
			order.setPrice(Integer.parseInt(text));
			break;
		default:
			break;
		}
	}
	
	private class Constants {
		private static final int START_ELEMENT = 1;
		private static final int END_ELEMENT = 2;
		private static final int PROCESSING_INSTRUCTION = 3;
		private static final int CHARACTERS = 4;
		private static final int COMMENT = 5;
		private static final int SPACE = 6;
		private static final int START_DOCUMENT = 7;
		private static final int END_DOCUMENT = 8;
		private static final int ENTITY_REFERENCE = 9;
		private static final int ATTRIBUTE = 10;
		private static final int DTD = 11;
		private static final int CDATA = 12;
		private static final int NAMESPACE = 13;
		private static final int NOTATION_DECLARATION = 14;
		private static final int ENTITY_DECLARATION = 15;
	}

}
