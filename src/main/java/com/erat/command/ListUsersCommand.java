package com.erat.command;

import com.erat.db.DBException;
import com.erat.db.UserRepository;
import com.erat.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListUsersCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
		List<User> users = new UserRepository().getAll();
		req.setAttribute("users", users);
		return "userList.jsp";
	}

	@Override
	public String toString() {
		return "ListUsers";
	}
}
