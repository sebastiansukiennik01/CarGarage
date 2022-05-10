package com.example.application;

import java.sql.*;

public class SqlDbFaktura implements SqlDbFakturaInterface {

    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";


    @Override
    public void insertInvoice(Faktura invoice, String date) {

    }

    @Override
    public void removeInvoice(Faktura invoice) {

    }
}
