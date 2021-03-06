package com.epam.db;

import com.epam.db.entity.Cruise;
import com.epam.db.entity.Liner;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CruiseRepository implements CrudRepository<Cruise, Long> {

    private static final String SQL_GET_ALL = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id";
    private static final String SQL_GET_BY_ID = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id WHERE t1.id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM cruises WHERE id = ?";
    private static final String SQL_DELETE_BY_NAME = "DELETE FROM cruises WHERE name = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE cruises SET name = ?, start_time = ?, end_time = ?, liner_id = ? WHERE id = ?";
    private static final String SQL_CREATE_CRUISE = "INSERT INTO cruises (name, start_time, end_time, liner_id) VALUES (?, ?, ?, ?)";
    private static final String SQL_GET_ALL_ASCEND_BY_LINER_NAME = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id ORDER BY liner_name ASC";
    private static final String SQL_GET_ALL_BY_START_TIME = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id WHERE start_time between ? and ?";
    private static final String SQL_GET_ALL_DESCEND_BY_LINER_NAME = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id ORDER BY liner_name DESC";
    /*private static final String SQL_GET_ALL_DESCEND_BY_NAME = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id ORDER BY t1.name DESC";
    private static final String SQL_GET_ALL_ASCEND_BY_NAME = "SELECT t1.name, t1.start_time, t1.end_time, t1.liner_id, t1.id " +
            "as route_id, t2.name as liner_name, t2.passengers, t2.crew" +
            " FROM cruises as t1 JOIN (SELECT * FROM liners) as t2 ON t1.liner_id = t2.id ORDER BY t1.name ASC";*/

    @Override
    public List<Cruise> getAll() {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Cruise> getAllDescendByLinerName() {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_DESCEND_BY_LINER_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Cruise> getAllAscendByLinerName() {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_ASCEND_BY_LINER_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
   /* public List<Cruise> getAllDescendByName() {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_DESCEND_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }*/

   /* public List<Cruise> getAllAscendByName() {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_ASCEND_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }*/

    @Override
    public Cruise getById(Long id) {
        Cruise cruise = new Cruise();
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
            }
            resultSet.close();
            preparedStatement.close();
            return cruise;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result != 0;
    }

    @Override
    public Cruise updateById(Cruise cruise, Long id) {
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            Cruise newCruise = getById(id);
            if (cruise.getName() != null){
                newCruise.setName(cruise.getName());
            }
            if (cruise.getStartTime() != null){
                newCruise.setStartTime(cruise.getStartTime());
            }
            if (cruise.getEndTime() != null){
                newCruise.setEndTime(cruise.getEndTime());
            }
            if (cruise.getLiner() != null){
                newCruise.setLiner(cruise.getLiner());
            }
            preparedStatement.setString(1, newCruise.getName());
            preparedStatement.setTimestamp(2, newCruise.getStartTime());
            preparedStatement.setTimestamp(3, newCruise.getEndTime());
            preparedStatement.setLong(4, newCruise.getLiner().getId());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return newCruise;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cruise create(Cruise cruise) {
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_CRUISE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cruise.getName());
            preparedStatement.setTimestamp(2, cruise.getStartTime());
            preparedStatement.setTimestamp(3, cruise.getEndTime());
            preparedStatement.setLong(4, cruise.getLiner().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                cruise.setId(resultSet.getLong(1));
            }
            resultSet.close();
            preparedStatement.close();
            return cruise;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public boolean deleteByName(String name) {
        int result = 0;
        ConnectionPool.getInstance();
        try (Connection connection = ConnectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NAME);
            preparedStatement.setString(1, name);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result != 0;
    }


    public List<Cruise> getAllByEndTime() {
        List<Cruise> cruises = new ArrayList<>();
        return cruises;
    }

    public List<Cruise> getAllByStartTime(String start, String end) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_BY_START_TIME);
            preparedStatement.setString(1, start);
            preparedStatement.setString(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruises = new ArrayList<>();
            while (resultSet.next()) {
                Cruise cruise = new Cruise();
                Liner liner = new Liner();
                cruise.setName(resultSet.getString("name"));
                cruise.setStartTime(resultSet.getTimestamp("start_time"));
                cruise.setEndTime(resultSet.getTimestamp("end_time"));
                cruise.setId(resultSet.getLong("route_id"));
                liner.setName(resultSet.getString("liner_name"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setId(resultSet.getLong("liner_id"));
                cruise.setLiner(liner);
                cruises.add(cruise);
            }
            resultSet.close();
            preparedStatement.close();
            return cruises;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
