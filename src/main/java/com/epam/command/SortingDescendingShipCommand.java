package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.LinerRepository;
import com.epam.db.entity.Cruise;
import com.epam.db.entity.Liner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDescendingShipCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruisesAscend;
        String dateStart = (String) req.getSession().getAttribute("dateStart");
        String dateEnd = (String) req.getSession().getAttribute("dateEnd");
        System.out.println(dateStart + " " + dateEnd);
        if (req.getSession().getAttribute("dateStart") != null && req.getSession().getAttribute("dateEnd") != null){
            dateEnd += " 23:59:59";
            cruisesAscend = new CruiseRepository().getAllByStartTime(dateStart, dateEnd);
            System.out.println(cruisesAscend + "<-");
        }
        else {
            cruisesAscend = new CruiseRepository().getAll();
            System.out.println(cruisesAscend);
        }
        cruisesAscend = cruisesAscend.stream().sorted(((o1, o2) -> o2.getLiner().getName().compareTo(o1.getLiner().getName()))).collect(Collectors.toList());
        req.getSession().setAttribute("cruises", cruisesAscend);
        req.setAttribute("sortingLiners", "descendingLiners");
        req.getSession().removeAttribute("sortingNames");
        return "cruiseList.jsp";
    }
}
