package com.example.application;

import java.sql.*;

public class SqlDbSamochod {

    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";

    public static Samochody getCars(String PhoneNumber){
        Samochody cars = new Samochody();
        ResultSet rs = null;
        String sql = "SELECT * FROM Cars WHERE ClientPhoneNumber='" + PhoneNumber + "';";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        Statement statement = cnn.createStatement()){
            rs = statement.executeQuery(sql);
            while(rs.next()){
                try{
                    cars.addSamochod(new Samochod(rs.getString("LicenceNumber"),
                            rs.getString("ProductionYear"),
                            rs.getString("Model"),
                            Samochod.markaEnum.valueOf(rs.getString("Make"))));
                }
                catch (CarExistsException e){
                    e.printStackTrace();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }

    public static void insertCar(Samochod car, Klient client) throws SQLException{
        ResultSet rs  = null;
        String sql = "INSERT INTO Cars (LicenceNumber, Make, Model, ProductionYear, ClientPhoneNumber) " +
                "VALUES ('" + car.getNrRejstracyjny() + "', '" + car.getMarka() + "', '" + car.getModel() + "', '" + car.getRocznik() + "', '" + client.getNrTelefonu() + "')";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void removeCar(Samochod car) throws SQLException{
        ResultSet rs = null;
        String sql = "DELETE FROM Cars WHERE LicenceNumber='" + car.getNrRejstracyjny() + "';";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}
