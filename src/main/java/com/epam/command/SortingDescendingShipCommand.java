package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.LinerRepository;
import com.epam.db.entity.Cruise;
import com.epam.db.entity.Liner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortingDescendingShipCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruises = new CruiseRepository().getAllDescendByLinerName();
        req.setAttribute("cruises", cruises);
        req.setAttribute("sortingLiners", "descendingLiners");
        return "cruiseList.jsp";
    }
}
