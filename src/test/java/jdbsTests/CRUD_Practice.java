package jdbsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class CRUD_Practice {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila","root","269326");
    Statement statement;
    ResultSet resultSet;

    public CRUD_Practice() throws SQLException {
    }

    @Test
    public void createRecord() throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int rowsAffected = statement.executeUpdate("Insert Into language VALUES (8,'Spanish',sysdate());");
        System.out.println("rowsAffected = " + rowsAffected);
    }

    @Test
    public String readRecord() throws SQLException {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("select * from language where language_id=8;");
        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println("resultSet.getString(\"name\") = " + name);

        return name;
    }

    @Test
    public void updateRecord() throws SQLException {

        String expectedName = "SPANISH";
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int rowsAffected = statement.executeUpdate("update language set name = 'SPANISH' where language_id = 8;");

        Assert.assertEquals(readRecord(), expectedName);

    }

    @Test
    public void deleteRecord() throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        int rowAffected = statement.executeUpdate("delete from language where language_id = 8");
        System.out.println("rowAffected = " + rowAffected);

        Assert.assertEquals(rowAffected,1);

    }


}
