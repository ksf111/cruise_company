package com.erat.command;

import com.erat.db.CruiseRepository;
import com.erat.db.DBException;
import com.erat.db.LinerRepository;
import com.erat.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class UpdateCruisesCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "cruiseList.jsp";
        Cruise cruise = new Cruise();
        cruise.setName(req.getParameter("Name"));
        System.out.println("name ==> " + cruise.getName());
        cruise.setStartTime(Timestamp.valueOf(req.getParameter("Start time")));
        cruise.setEndTime(Timestamp.valueOf(req.getParameter("End time")));
        try {
            cruise.setLiner(new LinerRepository().getByName(req.getParameter("Liner")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        CruiseRepository cruiseRepository = new CruiseRepository();
        cruiseRepository.updateById(cruise, Long.parseLong(req.getParameter("Id")));
        List<Cruise> cruises = cruiseRepository.getAll();
        req.setAttribute("cruises", cruises);
        return address;
    }

    @Override
    public String toString() {
        return "UpdateCruises";
    }
}
