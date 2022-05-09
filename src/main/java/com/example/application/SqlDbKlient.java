package com.example.application;

import com.example.application.views.list.KlientView;

import java.beans.PropertyEditorSupport;
import java.sql.*;


public class SqlDbKlient {

    private static String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";

    public static Klienci getClients(){
        System.out.println("performing setup..");
        System.out.println("selecting data..");

        Klienci clients = new Klienci();
        ResultSet rs = null;
        try(Connection cnn = DriverManager.getConnection(cnnString); Statement statement = cnn.createStatement();){
            rs = statement.executeQuery("SELECT * FROM Clients");
            while(rs.next()){
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
                clients.dodajKlienta(new Klient(rs.getString("PhoneNumber"), rs.getString("Name"), rs.getString("Surname")));
            }
        }catch(SQLException | CustomerExistsException e){
            e.printStackTrace();
        }
        return clients;
    }

    public static void insertKlient(Klient client){
        System.out.println("inserting client..");
        String sql = "INSERT INTO Clients (PhoneNumber, Name, Surname)" +
                " VALUES (123123123, Maciej, Nagly);";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ResultSet rs = null;
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void removeKlient(Klient client){

    }
}


