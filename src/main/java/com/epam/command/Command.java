package com.epam.command;

import com.epam.db.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse resp)
            throws DBException;

}