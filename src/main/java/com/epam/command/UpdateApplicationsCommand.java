package com.epam.command;

import com.epam.db.ApplicationRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class UpdateApplicationsCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "applicationList.jsp";
        ApplicationRepository applicationRepository = new ApplicationRepository();
        applicationRepository.editStatus(req.getParameter("Status"),Long.valueOf(req.getParameter("Id")));
        List<Application> applications = applicationRepository.getAll();
        req.getSession().setAttribute("applications", applications);
        return address;
    }
}
