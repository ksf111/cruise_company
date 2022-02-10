package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DateStartCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String dateStart = req.getParameter("dateStart");
        String dateEnd = req.getParameter("dateEnd");
        System.out.println("dateStart ==> " + dateStart);
        System.out.println("dateEnd ==> " + dateEnd);
        req.getSession().setAttribute("dateStart", dateStart);
        req.getSession().setAttribute("dateEnd", dateEnd);
        List<Cruise> cruises;
        if (dateEnd == null){
            cruises = new CruiseRepository().getAll();
        }
        else {
            dateEnd += " 23:59:59";
            cruises = new CruiseRepository().getAllByStartTime(dateStart, dateEnd);
        }
        System.out.println(dateEnd);
        req.getSession().setAttribute("cruises", cruises);
        return "cruiseList.jsp";
    }
}
