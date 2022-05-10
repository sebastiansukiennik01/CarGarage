package com.example.application;

import java.sql.*;

public class SqlDbFaktura {

    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";


    public static void insertInvoice(Faktura invoice, String date) throws SQLException {
        ResultSet rs = null;
        String sql = "INSERT INTO Invoices (LicenceNumber, PhoneNumber, Date) " +
                "VALUES ('" + invoice.getSamochod().getNrRejstracyjny() + "', '" + invoice.getKlient().getNrTelefonu() + "', '" + date + "');";
        try(Connection cnn = DriverManager.getConnection(cnnString);
        PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}
