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


    public static void insertInvoice(Faktura invoice, String date) {

    }

    public static void removeInvoice(Faktura invoice) {

    }
}
