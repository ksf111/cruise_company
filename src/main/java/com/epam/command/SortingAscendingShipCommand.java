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

public class SortingAscendingShipCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruisesDescend;
        String dateStart = (String) req.getSession().getAttribute("dateStart");
        String dateEnd = (String) req.getSession().getAttribute("dateEnd");
        System.out.println(dateStart + " " + dateEnd);
        if (req.getSession().getAttribute("dateStart") != null && req.getSession().getAttribute("dateEnd") != null){
            dateEnd += " 23:59:59";
            cruisesDescend = new CruiseRepository().getAllByStartTime(dateStart, dateEnd);
            System.out.println(cruisesDescend + "<-");
        }
        else {
            cruisesDescend = new CruiseRepository().getAll();
            System.out.println(cruisesDescend);
        }
        cruisesDescend = cruisesDescend.stream().sorted((Comparator.comparing(o -> o.getLiner().getName()))).collect(Collectors.toList());
        req.getSession().setAttribute("cruises", cruisesDescend);
        req.setAttribute("sortingLiners", "ascendingLiners");
        req.getSession().removeAttribute("sortingNames");
        return "cruiseList.jsp";
    }
}
