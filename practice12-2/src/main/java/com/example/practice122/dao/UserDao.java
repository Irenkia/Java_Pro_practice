package com.example.practice122.dao;

import com.example.practice122.entity.User;
import com.example.practice122.exception.DaoException;
import com.example.practice122.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.practice122.exception.DaoException;
import com.example.practice122.util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
//@Repository
public class UserDao implements Dao<Integer, User>{
//    @Autowired
    private static final UserDao INSTANCE_USER_DAO = new UserDao();

    private static final String FIND_ALL_SQL = """
             SELECT * FROM users
            """;


    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE user_id = ?
            """;

    private static final String SAVE_SQL = """
            INSERT INTO users (name, surname, phone, gender) 
            VALUES (?, ?, ?, ?);
            """;

    private static final String UPDATE_SQL = """
            UPDATE users
            SET user_id = ?,
                name = ?,
                surname = ?,
                phone = ?,
                gender
            WHERE user_id = ?    
            """;

    private static final String DELETE_SQL = """
            DELETE FROM users
            WHERE user_id = ?
            """;

    public UserDao() {
    }

    @Override
    public List<User> findAll() {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = (List<User>) UserDao.getInstanceUserDao();
            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }
            return users;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private User buildUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("user_id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("phone"),
                resultSet.getString("gender")

        );
    }
    @Override
    public Optional<User> findById(Integer id) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public User save(User user) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                user.setUser_id(generatedKeys.getInt("user_id"));
            }
            return user;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, user.getUser_id());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static UserDao getInstanceUserDao() {
        return INSTANCE_USER_DAO;
    }

}

