package jdbsTests;

import java.sql.*;

public class BaseConnection {
    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:mysql://localhost/sakila";
        String dbUsername = "root";
        String dbPassword = "269326";



        System.out.println("\t\t -----------DB Baglantisi olusturuluyor ------");

        // create connection - Baglanti olustur
        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        System.out.println(connection.getMetaData().getDatabaseProductName());


        // create a statement - Query-sorgu aciklamasi / detayi hazirla
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        // run a query and get the results in ResultSet object -  Query i kos ve donen cevabi yakala

        ResultSet resultSet = statement.executeQuery("select * from customer;");

        resultSet.next();  // 1. satira cursoru getir...
        System.out.println("resultSet.getRow() = " + resultSet.getRow());  // Kacinci Row dayim yazdir...
        System.out.println(resultSet.getRow() + ".satir First name column value = " + resultSet.getString("first_name"));

        resultSet.next();  // 2. satira cursoru getir...
        System.out.println("resultSet.getRow() = " + resultSet.getRow());  // Kacinci Row dayim yazdir...
        System.out.println(resultSet.getRow() + ".satir First name column value = " + resultSet.getString("first_name"));
        System.out.println("resultSet.getInt(3) = " + resultSet.getString(4));  // column sirasi vererk value cagirabilirsin.
        System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));  // Column Integer ise resultset.getInt ile cagirmalsiin.


        resultSet.absolute(10);   // cursor 10.satira getir.
        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println(resultSet.getRow() + ".satir First name column value = " + resultSet.getString("first_name"));

        // resultSet.deleteRow();  // calismaz. cunku resultset read onlay tanimladik. updatable olmasi lazim...




    }
}
