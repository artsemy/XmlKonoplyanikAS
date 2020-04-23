package by.training.epam.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.training.epam.bean.Order;
import by.training.epam.dao.OrderTagName;

public class OrderSaxHandler extends DefaultHandler{
	
	private static final String ATTRIBUTE_ID = "id";
	
	List<Order> orders;
	Order order;
	List<String> drinks;
	OrderTagName tag;
	
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void startDocument() throws SAXException {
		orders = new ArrayList<Order>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag = OrderTagName.valueOf(qName.toUpperCase());
		switch (tag) {
		case ORDER:
			order = new Order();
			order.setId(Integer.parseInt(attributes.getValue(ATTRIBUTE_ID)));
			break;
		case DRINK_LIST:
			drinks = new ArrayList<String>();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String text = new String(ch, start, length);
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

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = OrderTagName.valueOf(qName.toUpperCase());
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
	
}
