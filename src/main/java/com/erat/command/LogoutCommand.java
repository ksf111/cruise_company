package com.erat.command;

import com.erat.db.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        HttpSession session = req.getSession();
        System.out.println(session);
        String address = "index.jsp";
        req.removeAttribute("login");
        req.removeAttribute("password");
        session.removeAttribute("loggedUser");
        session.invalidate();
        return address;
    }

    @Override
    public String toString() {
        return "Logout";
    }
}
