package com.epam.command;

import com.epam.db.DBException;
import com.epam.db.LinerRepository;
import com.epam.db.entity.Liner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListLinersCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        LinerRepository linerRepository = new LinerRepository();
        List<Liner> liners = linerRepository.getAll();
        System.out.println(liners);
        req.setAttribute("liners", liners);
        return "linerList.jsp";
    }

    @Override
    public String toString() {
        return "ListLiners";
    }
}
