package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortingAscendingNameCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruisesAscend = new CruiseRepository().getAllAscendByName();
        req.setAttribute("cruises", cruisesAscend);
        req.setAttribute("sortingNames", "ascendingNames");
        return "cruiseList.jsp";
    }
}
