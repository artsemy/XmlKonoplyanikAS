package by.training.epam.service;

import by.training.epam.service.impl.OrderParceDom;
import by.training.epam.service.impl.OrderParceSax;
import by.training.epam.service.impl.OrderParceStax;

public class ServiceFactory {
	
	private static ServiceFactory instance;
	
	OrderParceSax serviceSax;
	OrderParceStax serviceStax;
	OrderParceDom serviceDom;
	
	private ServiceFactory() {
		serviceSax = new OrderParceSax();
		serviceStax = new OrderParceStax();
		serviceDom = new OrderParceDom();
	}
	
	public static synchronized ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	public OrderService getServiceSax() {
		return serviceSax;
	}
	
	public OrderService getServiceStax() {
		return serviceStax;
	}
	
	public OrderService getServiceDom() {
		return serviceDom;
	}
}
