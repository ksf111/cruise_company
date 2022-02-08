package com.erat.db;


import com.erat.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements CrudRepository<User, Long>{

    private static final String SQL_GET_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_CREATE_USER = "INSERT INTO users (login, password, role_id, id) VALUES (?, MD5(?), ?, DEFAULT)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET login = ?, password = ?, role_id = ? WHERE id = ?";
    private static final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_USERS);
            while (resultSet.next()){
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getLong("role_id"));
                user.setId(resultSet.getLong("id"));
                users.add(user);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(Long id){
        User user = new User();
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()){
            System.out.println("con ==> " + connection);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getLong("role_id"));
                user.setId(id);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteById(Long id) {
        int result = 0;
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result != 0;
    }

    @Override
    public User updateById(User user, Long id) {
        ConnectionPool.getInstance();
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            User newUser = getById(id);
            if (user.getLogin() != null) {
                newUser.setLogin(user.getLogin());
            }
            if (user.getPassword() != null) {
                newUser.setPassword(user.getPassword());
            }
            if (user.getRoleId() != null) {
                newUser.setRoleId(user.getRoleId());
            }
            preparedStatement.setString(1, newUser.getLogin());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setLong(3, newUser.getRoleId());
            preparedStatement.setLong(4, id);
            preparedStatement.close();
            return newUser;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User create(User user){
        ConnectionPool.getInstance();
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getRoleId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                user.setId(resultSet.getLong(1));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public User getByLogin (String login){
        User user = new User();
        ConnectionPool.getInstance();
        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement((SQL_GET_USER_BY_LOGIN));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setLogin(login);
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getLong("role_id"));
                user.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

}

