package com.erat.servlet;

import com.erat.command.Command;
import com.erat.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String address = "error.jsp";
		String commandName = req.getParameter("command");
		System.out.println("commandName ==> " + commandName);
		Command command = CommandContainer.getCommand(commandName);
		System.out.println("command ==> " + command);
		try {
			address = command.execute(req, resp);
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("errorMessage", ex.getMessage());
		}
		System.out.println("forward ==> " + address);
		req.getRequestDispatcher(address).forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String address = "error.jsp";
		String commandName = req.getParameter("command");
		System.out.println("commandName ==> " + commandName);
		Command command = CommandContainer.getCommand(commandName);
		System.out.println("command ==> " + command);
		try {
			address = command.execute(req, resp);
		} catch (Exception ex) {
			ex.printStackTrace();
			req.getSession()
				.setAttribute("errorMessage", ex.getMessage());
		}
		System.out.println("redirect ==> " + address);
		resp.sendRedirect(address);
	}

}