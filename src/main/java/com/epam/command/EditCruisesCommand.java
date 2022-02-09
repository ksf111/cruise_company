package com.epam.command;

import com.epam.db.CruiseRepository;
import com.epam.db.DBException;
import com.epam.db.LinerRepository;
import com.epam.db.entity.Cruise;
import com.epam.db.entity.Liner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditCruisesCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruises = new CruiseRepository().getAll();
        List<Liner> liners = new LinerRepository().getAll();
        System.out.println(liners);
        req.setAttribute("cruises", cruises);
        req.setAttribute("liners", liners);
        String address = "editCruises.jsp";
        return address;
    }

    @Override
    public String toString() {
        return "EditCruises";
    }
}
