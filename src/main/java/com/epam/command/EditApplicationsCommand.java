package com.epam.command;

import com.epam.db.ApplicationRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class EditApplicationsCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "editApplications.jsp";
        System.out.println(Long.parseLong(req.getParameter("Id")));
        Application application = new ApplicationRepository().getById(Long.parseLong(req.getParameter("Id")));
        System.out.println(application);
        List<String> applicationStatus = new ArrayList<>();
        applicationStatus.add("Declined");
        applicationStatus.add("Approved");
        applicationStatus.add("Pending");
        req.setAttribute("application", application);
        req.setAttribute("statuses", applicationStatus);
        return address;
    }
}
