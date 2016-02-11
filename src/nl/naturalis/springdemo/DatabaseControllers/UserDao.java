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

    public User get(int id) {
        User user = null;
        try {
            String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + USER_ID + "=" + Integer.toString(id) + ";";
            statement = MySQLConnector.connect().prepareStatement(SQL);
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

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + TABLE_NAME + ";";
            statement = MySQLConnector.connect().prepareStatement(SQL);

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

    public void insert(User user) {
        try {
            String SQL = "INSERT INTO " + TABLE_NAME + "(" + USERNAME + ", " + PASSWORD + ", " + EMAIL + ")"
                    + " VALUES(?, ?, ?);";
            statement = MySQLConnector.connect().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            String SQL = "UPDATE " + TABLE_NAME + " SET " + USERNAME + "=?, " + PASSWORD + "=?, " + EMAIL + "=?"
                    + " WHERE " + USER_ID + "=?;";
            statement = MySQLConnector.connect().prepareStatement(SQL);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {
        try {
            String SQL = "DELETE FROM " + TABLE_NAME + " WHERE " + USER_ID + "=?;";
            statement = MySQLConnector.connect().prepareStatement(SQL);
            statement.setInt(1, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
