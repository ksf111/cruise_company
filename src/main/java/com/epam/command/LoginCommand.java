package com.epam.command;

import com.epam.db.DBException;
import com.epam.db.UserRepository;
import com.epam.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
		String address = "login.html";
		String login = req.getParameter("login");
		System.out.println("login ==> " + login);
		String password = req.getParameter("password");
		System.out.println("password ==> " + password);
		User user = new UserRepository().getByLogin(login);
		System.out.println("user ==> " + user);
		if (user != null && user.getPassword().equals(MD5(password))) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedUser", user);
			address = "index.jsp";
			System.out.println(session);
		}
		return address;
	}


	public String MD5(String password){
		byte[] passwordBytes = new byte[0];
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
			passwordBytes = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < passwordBytes.length; i++) {
			byte b = passwordBytes[i];
			String hex = Integer.toHexString((int) 0x00FF & b);
			if (hex.length() == 1){
				sb.append("0");
			}
			sb.append(hex);
		}
		String MD5password = sb.toString();
		return MD5password;
	}

	@Override
	public String toString() {
		return "Login";
	}
}
