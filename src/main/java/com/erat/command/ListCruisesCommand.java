package com.erat.command;

import com.erat.db.CruiseRepository;
import com.erat.db.DBException;
import com.erat.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListCruisesCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruises = new CruiseRepository().getAll();
        req.setAttribute("cruises", cruises);
        return "cruiseList.jsp";
    }

    @Override
    public String toString() {
        return "ListCruises";
    }
}
