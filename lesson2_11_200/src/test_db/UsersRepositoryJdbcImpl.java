package test_db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository{
    private Connection connection;
    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from accounts";
    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAllByAge(Integer age) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getInt("age")
                );
                if (user.getAge() == age) {
                    result.add(user);
                }
            }
            if (result.isEmpty()) {
                System.out.println("По введенному возврасту ничего не найдено");
            }
            result.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName() ));
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List findAllByName(String name) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getInt("age")
                );
                if (user.getFirstName().equals(name)) {
                    result.add(user);
                }
            }
            if (result.isEmpty()) {
                System.out.println("По введенному возврасту ничего не найдено");
            }
            result.forEach(user -> System.out.println("ID " + user.getId() + ": " + user.getFirstName()));
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List findAll(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getInt("age")
                );
                if (user.getId() == id) {
                    result.add(user);
                }
            }
            if (result.isEmpty()) {
                System.out.println("По введенному возврасту ничего не найдено");
            }
            result.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName() ));
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
