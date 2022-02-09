package com.epam.db;

import com.epam.db.entity.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {
    private static final String SQL_SUBMIT_APPLICATION = "INSERT INTO applications (cruise_id, login, name, surname, birthdate, status, id) VALUES (?, ?, ?, ?, ?, ?, DEFAULT)";
    private static final String SQL_GET_ALL_APPLICATIONS = "SELECT * FROM applications";
    private static final String SQL_EDIT_STATUS = "UPDATE applications set status = ? where id = ?";
    private static final String SQL_GET_BY_ID = "SELECT * FROM applications where id = ?";

    public Application submit(Application application) {
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SUBMIT_APPLICATION, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, application.getCruiseId());
            preparedStatement.setString(2, application.getLogin());
            preparedStatement.setString(3, application.getName());
            preparedStatement.setString(4, application.getSurname());
            preparedStatement.setDate(5, application.getBirthdate());
            preparedStatement.setString(6, application.getStatus());
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

    public List<Application> getAll(){
        List<Application> applications = new ArrayList<>();
        try(Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL_GET_ALL_APPLICATIONS);
            while (resultset.next()) {
                Application application = new Application();
                application.setCruiseId(resultset.getLong("cruise_id"));
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

    public void editStatus(String status, Long id){
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EDIT_STATUS);
            preparedStatement.setString(1, status);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Application getById(Long id){
        Application application = new Application();
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                application.setCruiseId(resultSet.getLong("cruise_id"));
                application.setLogin(resultSet.getString("login"));
                application.setName(resultSet.getString("name"));
                application.setSurname(resultSet.getString("surname"));
                application.setStatus(resultSet.getString("status"));
                application.setBirthdate(resultSet.getDate("birthdate"));
                application.setId(id);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return application;
    }
}
