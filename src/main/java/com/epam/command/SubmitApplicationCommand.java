package com.epam.command;

import com.epam.db.ApplicationRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class SubmitApplicationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        Application application = new Application();
        application.setCruiseId(Long.parseLong(req.getParameter("CruiseId")));
        application.setLogin(req.getParameter("Login"));
        application.setName(req.getParameter("Name"));
        application.setSurname(req.getParameter("Surname"));
        application.setBirthdate(Date.valueOf(req.getParameter("Birthdate")));
        application.setStatus("Pending");
        ApplicationRepository applicationRepository = new ApplicationRepository();
        applicationRepository.submit(application);
        System.out.println(application);
        return "submitSuccess.jsp";
    }
}
