package com.erat.db;

import com.erat.db.entity.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {
    private static final String SQL_SUBMIT_APPLICATION = "INSERT INTO applications (login, name, surname, birthdate, status, id) VALUES (?, ?, ?, ?, 'In progress', DEFAULT)";
    private static final String SQL_GET_ALL_APPLICATIONS = "SELECT * FROM aplications";

    public Application submit(Application application) {
        ConnectionPool.getInstance();
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SUBMIT_APPLICATION, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, application.getLogin());
            preparedStatement.setString(2, application.getName());
            preparedStatement.setString(3, application.getSurname());
            preparedStatement.setDate(4, application.getBirthdate());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                application.setId(resultSet.getLong(1));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return application;
    }

    public List<Application> GetAll(){
        List<Application> applications = new ArrayList<>();
        ConnectionPool.getInstance();
        try(Connection connection = ConnectionPool.getConnection()) {
            Application application = new Application();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL_GET_ALL_APPLICATIONS);
            while (resultset.next()) {
                application.setLogin(resultset.getString("login"));
                application.setName(resultset.getString("name"));
                application.setSurname(resultset.getString("surname"));
                application.setStatus(resultset.getString("status"));
                application.setBirthdate(resultset.getDate("birthdate"));
                application.setId(resultset.getLong("id"));
                applications.add(application);
            }
            resultset.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return applications;

    }
}
