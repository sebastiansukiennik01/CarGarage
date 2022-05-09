package com.example.application;

import com.example.application.views.list.KlientView;

import java.beans.PropertyEditorSupport;
import java.sql.*;


public class SqlDbKlient {

    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";

    public static Klienci getClients() throws WrongNumberException{
        Klienci clients = new Klienci();
        ResultSet rs = null;
        try(Connection cnn = DriverManager.getConnection(cnnString); Statement statement = cnn.createStatement()){
            rs = statement.executeQuery("SELECT * FROM Clients");
            while(rs.next()){
                clients.dodajKlienta(new Klient(rs.getString("PhoneNumber"), rs.getString("Name"), rs.getString("Surname")));
            }
        }catch(SQLException | CustomerExistsException e){
            e.printStackTrace();
        }
        return clients;
    }

    public static void insertKlient(Klient client) throws SQLException{
        String sql = "INSERT INTO Clients (PhoneNumber, Name, Surname) VALUES ('" + client.getNrTelefonu() + "', '" + client.getImie() + "', '" + client.getNazwisko() + "');";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ResultSet rs = null;
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void removeKlient(Klient client){
        System.out.println("inserting client..");
        String sql = "DELETE FROM Clients WHERE PhoneNumber='" + client.getNrTelefonu() + "';";
        try(Connection cnn = DriverManager.getConnection(cnnString);
            PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ResultSet rs = null;
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


