package com.example.finaltest2022;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DBUtil {

    private static Connection connection = null;

    private static Statement statement = null;

public static Connection dbConnect() throws  SQLException
{
    //Connecting to the DB
    String dbURL ="jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    String username = "COMP228_F22_sh_13";
    String password = "password";

    try
    {
        connection = DriverManager.getConnection(dbURL, username, password);
        System.out.print("Connected to the database");
        statement = connection.createStatement();
    }
    catch (SQLException e)
    {
        System.out.print("Connection failed");
        System.out.print(e.getMessage());
    }
    return connection;
}

//Closing database

    public static void dbDisconnect() throws SQLException
    {
        try
        {
            if(connection != null && !connection.isClosed());
            {
                connection.close();
                System.out.print("Disconnected from the database");
            }
        }
    catch (Exception e)
    {
        throw e;
    }
    }

public static void createTable (String tableName) throws SQLException
{
    dbConnect();
    String sql = "CREATE TABLE" + tableName + "(book_id INTEGER PRIMARY KEY, title VARCHAR (100), author VARCHAR(100), category VARCHAR(50), year INTEGER)";
    try
    {
        statement.execute(sql);
        System.out.println("Table" + tableName+ "is created");
    }
catch (SQLException e)
{
    System.out.println("ERROR! Table is not created" + tableName);
    System.out.println(e.getMessage());
}
}

public static void dropTable (String tableName) throws  SQLException
{
    dbConnect();
    String sql = "DROP TABLE" + tableName;
    try
    {
        statement.execute(sql);
        System.out.println("Table" + tableName+ "is dropped");
    }
    catch (SQLException e)
    {
        System.out.println("Table is not dropped" + tableName);
        System.out.println(e.getMessage());
    }
}

public static  void insertData(String tableName, int book_id, String book_category, String book_title, int book_year, String book_author) throws  SQLException
{
    dbConnect();
    try
    {
        String sql = "INSERT INTO" + tableName + "VALUES (" + book_id + " , " + book_category + ", " + book_title + "," + book_year + " ," + book_author + ")";
        System.out.println(sql);
        statement.executeUpdate(sql);
        System.out.println("Data has been inserted to the table");
    }
catch (SQLException e)
{
    System.out.println("Data is not inserted to the table");
    System.out.println(e.getMessage());
}
}

public static void deleteData (String tableName, int book_id) throws SQLException
{
    dbConnect();
    String sql = "DELETE FROM" + tableName + "where b_id =" +book_id;
    statement.executeUpdate(sql);
    System.out.println("Data is deleted");
    if (statement != null)
    {
        statement.close();
    }
    dbDisconnect();
}

public static ResultSet query (String sql) throws SQLException
{

    CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();

    dbConnect();

    ResultSet resultSet = null;
    try
    {
        resultSet = statement.executeQuery(sql);
        crs.populate(resultSet);
    }
    catch (SQLException e)
    {
        System.out.println("Query did not run");
        System.out.println(e.getMessage());
    }
    if (statement !=null)
    {
        statement.close();
    }
    dbDisconnect();
    return crs;
}

public static void addBook (String tableName, int book_id, String book_category, String book_title, String book_year, int book_author) throws  SQLException
{
    dbConnect();
    try
    {
        String sql = "INSERT INTO" + tableName + "VALUES (" + book_id + " , " + book_category + ", " + book_title + "," + book_year + " ," + book_author + ")";
        System.out.println(sql);
        statement.executeUpdate(sql);
        System.out.println("Data has been inserted to the table");
    }
    catch (SQLException e)
    {
        System.out.println("Data is not inserted to the table");
        System.out.println(e.getMessage());
    }
    if (statement !=null)
    {
        statement.close();
    }
    dbDisconnect();
}



public static  void main   (String [ ] args) throws SQLException
{
    dbConnect();
 //dbDisconnect();
 createTable("Book");
}



}