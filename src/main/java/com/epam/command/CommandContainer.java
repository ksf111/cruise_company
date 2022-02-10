package com.epam.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
	
	private static final Map<String, Command> commands;
	
	static {
		commands = new HashMap<>();
		
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("listUsers", new ListUsersCommand());
		commands.put("listLiners", new ListLinersCommand());
		commands.put("listCruises", new ListCruisesCommand());
		commands.put("register", new RegisterCommand());
		commands.put("editCruises", new EditCruisesCommand());
		commands.put("updateCruises", new UpdateCruisesCommand());
		commands.put("bookTicket", new BookTicketCommand());
		commands.put("submitApplication", new SubmitApplicationCommand());
		commands.put("listApplication", new ListApplicationCommand());
		commands.put("editApplications", new EditApplicationsCommand());
		commands.put("updateApplications", new UpdateApplicationsCommand());
		commands.put("sortingAscendingName", new SortingAscendingNameCommand());
		commands.put("sortingDescendingName", new SortingDescendingNameCommand());
		commands.put("sortingAscendingShip", new SortingAscendingShipCommand());
		commands.put("sortingDescendingShip", new SortingDescendingShipCommand());
		commands.put("dateStart", new DateStartCommand());
		// ...
	}

	public static Command getCommand(String commandName) {
		return commands.get(commandName);
	}

}
