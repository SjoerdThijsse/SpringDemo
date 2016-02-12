package nl.naturalis.springdemo.DatabaseControllers;

import nl.naturalis.springdemo.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
public class UserDao {

    private final static String TABLE_NAME = "user";

    private final static String USER_ID = "userId";
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static String EMAIL = "email";

    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private static UserDao instance = null;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if(instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User get(int id) {
        User user = null;
        try {
            String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + USER_ID + "=?;";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.first()) {
                user = new User(resultSet.getInt(USER_ID),
                        resultSet.getString(USERNAME),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(EMAIL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User get(String username, String password) {
        User user = null;
        try {
            String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + USERNAME + "=? AND " + PASSWORD + "=?;";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            if (resultSet.first()) {
                user = new User(resultSet.getInt(USER_ID),
                        resultSet.getString(USERNAME),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(EMAIL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + TABLE_NAME + ";";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(USER_ID),
                        resultSet.getString(USERNAME),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(EMAIL)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int insert(User user) {
        try {
            String SQL = "INSERT INTO " + TABLE_NAME + "(" + USERNAME + ", " + PASSWORD + ", " + EMAIL + ")"
                    + " VALUES(?, ?, ?);";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            return statement.executeUpdate();
        } catch (SQLException e) {
            if(e.getErrorCode() == MySQLConnector.MYSQL_DUPLICATE_CODE){
                // logger.info("Duplicate key error")
                return -1;
            } else {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int update(User user) {
        try {
            String SQL = "UPDATE " + TABLE_NAME + " SET " + USERNAME + "=?, " + PASSWORD + "=?, " + EMAIL + "=?"
                    + " WHERE " + USER_ID + "=?;";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getUserId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(User user) {
        try {
            String SQL = "DELETE FROM " + TABLE_NAME + " WHERE " + USER_ID + "=?;";
            statement = MySQLConnector.getInstance().getConnection().prepareStatement(SQL);
            statement.setInt(1, user.getUserId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
