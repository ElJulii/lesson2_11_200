import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "gjhfqr102";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/11-200";


    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from accounts");

        while (result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("first_name"));
        }

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        int age = scanner.nextInt();

        String sqlInsertUser = "insert into accounts(first_name, second_name, age) values('" +
                firstName +"', '" + secondName + "', '" + age + "');";

        int affectedRows = statement.executeUpdate(sqlInsertUser);

        System.out.println("Было добавлено " + affectedRows + " строк");



    }
}