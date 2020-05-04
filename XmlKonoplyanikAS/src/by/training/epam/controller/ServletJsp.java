package by.training.epam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.epam.controller.command.Command;
import by.training.epam.controller.command.CommandFactory;

@WebServlet("/ServletJsp")
public class ServletJsp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ServletJsp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCommand = request.getParameter(ServletConstant.COMMAND_ATTR);
		CommandFactory factory = new CommandFactory();
		Command command = factory.getCommand(sCommand);
		command.execute(request, response);
	}

}
