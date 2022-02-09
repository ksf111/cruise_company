package com.epam.db;


public class DBManager {
    private static DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }


    public static void main(String[] args) {
        DBManager dbManager = DBManager.getInstance();

        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.getAll());
    }

}
