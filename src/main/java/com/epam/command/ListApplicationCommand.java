package com.epam.command;

import com.epam.db.ApplicationRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListApplicationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "applicationList.jsp";
        List<Application> applications = new ApplicationRepository().getAll();
        System.out.println(applications);
        req.setAttribute("applications", applications);
        return address;
    }
}
