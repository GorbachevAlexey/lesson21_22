package ru.sbt.java.school.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CacheDAO extends AbsCacheDAO implements ICacheDAO {

    private final String connUrl;
    private final String SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS cache( key INT PRIMARY KEY, value INT NOT NULL);";

    private static final String SQL_MERGE =
            "MERGE INTO CACHE KEY(Key) VALUES(?, ?);";

    private static final String SQL_SELECT =
            "SELECT Key, Value FROM Cache";

    public CacheDAO(String connUrl) {
        this.connUrl = connUrl;
        createTable();
    }

    private void createTable() {
        try (Connection connection = getConnection(connUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create table", e);
        }
    }

    @Override
    public void save(Integer key, Integer value) {
        try (Connection connection = getConnection(connUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_MERGE)) {

            preparedStatement.setInt(1, key);
            preparedStatement.setInt(2, value);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't save cache", e);
        }
    }

    @Override
    public Map<Integer, Integer> load() {
        Map<Integer,Integer> map = new HashMap<>();
        try(Connection connection = getConnection(connUrl);
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()){
                map.put(resultSet.getInt("key"), resultSet.getInt("value"));
            }
            return map;
        } catch (SQLException e) {
            throw new RuntimeException("Can't load cache", e);
        }
    }
}
