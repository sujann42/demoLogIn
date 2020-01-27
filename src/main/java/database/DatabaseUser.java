package database;

import java.sql.*;

public class DatabaseUser {

    String url = "jdbc:mysql://localhost:3306/cubic";
    String username = "root";
    String password = "";
    String query = "select * from users where name=? and pass=?";


    public boolean check(String user, String pass) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+ " "+ resultSet.getString(2));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    return  false;
    }

}




