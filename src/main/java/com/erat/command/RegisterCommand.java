package com.erat.command;

import com.erat.db.DBException;
import com.erat.db.UserRepository;
import com.erat.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "register.jsp";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login == null || login.contains(" ") || !login.matches("^[a-z0-9_-]{4,16}$")){
            req.setAttribute("error", "Login must be 4 to 16 characters with any lower case character, digit or special symbol “_-” only.");
            System.out.println("login ==> " + login);
            try {
                req.getRequestDispatcher(address).forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else if(password == null || !password.matches("^[a-zA-Z0-9]{8,16}$")){
            req.setAttribute("error", "Password must be 8 to 16 characters with any character or digit only.");
            try {
                req.getRequestDispatcher(address).forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else if (login.equals(new UserRepository().getByLogin(login).getLogin())){
            try {
                req.setAttribute("error", "This login is already taken, please choose another one");
                req.getRequestDispatcher(address).forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            UserRepository repository = new UserRepository();
            User user = repository.create(new User(login, password, 2L));
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);
            address = "index.jsp";
            System.out.println(session);
        }
        return address;
    }

    @Override
    public String toString() {
        return "Register";
    }
}
