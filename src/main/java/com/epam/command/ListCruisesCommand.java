package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListCruisesCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruises = new CruiseRepository().getAll();
        req.getSession().setAttribute("cruises", cruises);
        req.getSession().setAttribute("sortingNames", "ascendingNames");
        req.getSession().setAttribute("sortingShips", "ascendingShips");
        req.getSession().removeAttribute("dateStart");
        req.getSession().removeAttribute("dateEnd");
        return "cruiseList.jsp";
    }

    @Override
    public String toString() {
        return "ListCruises";
    }
}
