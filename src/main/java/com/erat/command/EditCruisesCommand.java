package com.erat.command;

import com.erat.db.CruiseRepository;
import com.erat.db.DBException;
import com.erat.db.entity.Cruise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditCruisesCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Cruise> cruises = new CruiseRepository().getAll();
        req.setAttribute("cruises", cruises);
        String address = "editCruises.jsp";
        req.setAttribute("cruises", cruises);
        return address;
    }

    @Override
    public String toString() {
        return "EditCruises";
    }
}
