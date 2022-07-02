package SQL;

import java.sql.*;

public class Msql {

    public Msql(){
    }
    private final static String dbURL="jdbc:mysql://42.193.182.170:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static Connection connectData(){
        Connection dbConn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConn= DriverManager.getConnection(dbURL,"root","Chenjiliang");
            System.out.println("Successfully connected!");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connected fail!");
            System.exit(-1);
        }
        return dbConn;
    }

    public static void freeConnect(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();

    }

    public static void freeConnect(Connection connection, Statement statement) throws SQLException {
        connection.close();
        statement.close();

    }

    public static void freeConnect(Connection connection) throws SQLException {
        connection.close();

    }

}
