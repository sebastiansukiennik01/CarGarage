package com.example.application;

import jdk.jshell.spi.ExecutionControl;

import java.sql.*;

public class SqlDbUsluga {

    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";

    public static Uslugi getServices() throws SQLException {
        Uslugi services = new Uslugi();
        ResultSet rs = null;
        String sql = "SELECT * FROM Services";
        try (Connection cnn = DriverManager.getConnection(cnnString); Statement statement = cnn.createStatement()) {
            rs = statement.executeQuery(sql);
            while(rs.next()){
                services.addUsluga(new Usluga(rs.getString("Name"), rs.getFloat("Price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return services;
    }

    public static void insertService(Usluga service) throws SQLException {
        ResultSet rs = null;
        String sql = "INSERT INTO Services (Name, Price) VALUES ('" + service.getNazwa() + "', " + service.getKoszt() + ");";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void removeService(Usluga service) throws SQLException {
        ResultSet rs = null;
        String sql = "DELETE FROM Services WHERE ServiceID=" + service.getIdUslugi();
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}

