package by.training.epam.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.epam.bean.Order;
import by.training.epam.controller.command.Command;
import by.training.epam.service.OrderService;
import by.training.epam.service.ServiceException;
import by.training.epam.service.ServiceFactory;

public class doDom implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServiceFactory factory = ServiceFactory.getInstance();
			OrderService service = factory.getServiceDom();
			List<Order> orders = service.parce();
			request.setAttribute("array", orders);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}