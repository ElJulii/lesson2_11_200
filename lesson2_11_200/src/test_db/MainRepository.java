package test_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;


public class MainRepository {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "gjhfqr102";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/11-200";


    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        System.out.println("Users, who are 25 years old: ");
        List<User> users_age = usersRepository.findAllByAge(25);
        System.out.println("The user Julian has the ID: ");
        List<User> users_name = usersRepository.findAllByName("Julian");
        System.out.println("The user, who has got the ID 3: ");
        List<User> users_id = usersRepository.findAll(3);
    }
}
