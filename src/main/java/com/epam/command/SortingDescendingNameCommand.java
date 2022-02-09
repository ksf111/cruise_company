package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortingDescendingNameCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruisesDescend = new CruiseRepository().getAllDescendByName();
        req.setAttribute("cruises", cruisesDescend);
        req.setAttribute("sortingNames", "descendingNames");
        return "cruiseList.jsp";
    }
}
