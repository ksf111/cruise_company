package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.UserRepository;
import com.epam.db.entity.Cruise;
import com.epam.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookTicketCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "bookTicket.jsp";
        User user = new UserRepository().getByLogin(req.getParameter("loggedUser"));
        String cruiseName = new CruiseRepository().getById(Long.parseLong(req.getParameter("cruiseId"))).getName();
        System.out.println(user);

        req.getSession().setAttribute("loggedUser", user);
        req.getSession().setAttribute("cruiseName", cruiseName);
        req.getSession().setAttribute("cruiseId", req.getParameter("cruiseId"));
        return address;
    }

    @Override
    public String toString() {
        return "BookTicket";
    }
}
