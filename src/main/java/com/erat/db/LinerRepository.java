package com.erat.db;

import com.erat.db.entity.Liner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinerRepository implements CrudRepository <Liner, Long>{

    private static final String SQL_GET_ALL = "SELECT * FROM liners";
    private static final String SQL_CREATE_LINER = "INSERT INTO liners (name, passengers, crew) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_BY_ID = "UPDATE liners SET name = ?, passengers = ?, crew = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM liners WHERE id = ?";
    private static final String SQL_GET_BY_ID = "SELECT * FROM liners WHERE id = ?";
    private static final String SQL_GET_BY_NAME = "SELECT * FROM liners WHERE name = ?";
    private static final String SQL_DELETE_BY_NAME = "DELETE FROM liners WHERE name = ?";

    @Override
    public List<Liner> getAll() {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Liner> liners = new ArrayList<>();
            while (resultSet.next()) {
                Liner liner = new Liner();
                liner.setId(resultSet.getLong("id"));
                liner.setName(resultSet.getString("name"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liners.add(liner);
            }
            resultSet.close();
            preparedStatement.close();
            return liners;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Liner getById(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Liner liner = new Liner();
            while (resultSet.next()){
                liner.setId(resultSet.getLong("id"));
                liner.setName(resultSet.getString("name"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setPassengers(resultSet.getInt("passengers"));
            }
            resultSet.close();
            preparedStatement.close();
            return liner;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Liner create(Liner liner) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_LINER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, liner.getName());
            preparedStatement.setInt(2, liner.getPassengers());
            preparedStatement.setInt(3, liner.getCrew());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                liner.setId(resultSet.getLong(1));
            }
            resultSet.close();
            preparedStatement.close();
            return liner;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id){
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
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
    public Liner updateById(Liner liner, Long id){
        try(Connection connection = ConnectionPool.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            Liner newLiner = getById(id);
            if (liner.getName() != null) {
                newLiner.setName(liner.getName());
            }
            if (liner.getPassengers() != null) {
                newLiner.setPassengers(liner.getPassengers());
            }
            if (liner.getCrew() != null) {
                newLiner.setCrew(liner.getCrew());
            }
            preparedStatement.setString(1, newLiner.getName());
            preparedStatement.setInt(2, newLiner.getPassengers());
            preparedStatement.setInt(3, newLiner.getCrew());
            preparedStatement.setLong(4, id);
            preparedStatement.close();
            return newLiner;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Liner getByName(String name) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            Liner liner = new Liner();
            while (resultSet.next()){
                liner.setId(resultSet.getLong("id"));
                liner.setName(resultSet.getString("name"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setPassengers(resultSet.getInt("passengers"));
            }
            resultSet.close();
            preparedStatement.close();
            return liner;
        }
    }

    public boolean deleteByName(String name) {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NAME);
            preparedStatement.setString(1, name);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }






    public static void main(String[] args) {
        LinerRepository repo = new LinerRepository();
        System.out.println(repo.getAll());
        System.out.println(repo.create(Liner.builder()
                        .id(-1L)
                        .crew(10)
                        .passengers(100)
                        .name("Augustus")
                .build()));
        System.out.println(repo.deleteByName("Augustus"));
        System.out.println(repo.getAll());

    }
}
