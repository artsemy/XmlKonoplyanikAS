package by.training.epam.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.epam.bean.Order;
import by.training.epam.controller.ServletConstant;
import by.training.epam.controller.command.Command;
import by.training.epam.service.OrderService;
import by.training.epam.service.ServiceException;
import by.training.epam.service.ServiceFactory;

public class doSax implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServiceFactory factory = ServiceFactory.getInstance();
			OrderService service = factory.getServiceSax();
			List<Order> orders = service.parce();
			request.setAttribute(ServletConstant.ARRAY_ATTR, orders);
			request.getRequestDispatcher(ServletConstant.TABLE_PAGE).forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher(ServletConstant.ERROR_PAGE).forward(request, response);
		}
	}

}
