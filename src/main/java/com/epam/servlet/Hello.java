package com.epam.servlet;

import com.epam.db.LinerRepository;
import com.epam.db.UserRepository;
import com.epam.db.entity.Liner;
import com.epam.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Hello");
        UserRepository userRepository = new UserRepository();
        LinerRepository linerRepository = new LinerRepository();
        List<User> userList = userRepository.getAll();
        System.out.println(userList);
        List<Liner> linerList = linerRepository.getAll();
        System.out.println(linerList);
        req.setAttribute("users", userList);
        req.setAttribute("liners", linerList);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository();
        LinerRepository linerRepository = new LinerRepository();
        List<User> userList = userRepository.getAll();
        List<Liner> linerList = linerRepository.getAll();
        req.getSession().setAttribute("users", userList);
        req.getSession().setAttribute("liners", linerList);
        resp.sendRedirect("hello");
    }
}
