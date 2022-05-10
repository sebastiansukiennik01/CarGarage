package com.example.application;

import java.sql.*;

public class SqlDbProdukt {
    private static final String cnnString =
            "jdbc:sqlserver://tomeksolarskiserver.database.windows.net:1433;" +
                    "database=GarageDB;" +
                    "user=tomek@tomeksolarskiserver;" +
                    "password=Dupasmoka2115;" +
                    "encrypt=true;" +
                    "trustServerCertificate=false;" +
                    "hostNameInCertificate=*.database.windows.net;" +
                    "loginTimeout=30;";

    public static Produkty getProducts() throws SQLException {

        Produkty products = new Produkty();
        ResultSet rs = null;
        try(Connection cnn = DriverManager.getConnection(cnnString); Statement statement = cnn.createStatement()){
            rs = statement.executeQuery("SELECT * FROM Products");
            while(rs.next()){
                products.addProducts(new Produkt(rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getFloat("Amount"),
                        rs.getFloat("Price"),
                        Produkt.jednostkaEnum.valueOf(rs.getString("Unit"))));
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        return products;
    }

    public static void insertProdukt(Produkt product) throws SQLException{
        String sql = "INSERT INTO Products (Name, Amount, Price, Unit) VALUES ('" + product.getNazwa() + "', " + product.getIlosc() + ", " + product.getCena() + ", '" + product.getJednostka().toString() + "');";
        try(Connection cnn = DriverManager.getConnection(cnnString);
            PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ResultSet rs = null;
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void removeProduct(Produkt product) throws SQLException{
       String sql = "DELETE FROM Products WHERE ProductID=" + product.getNrProduktu() + ";";
       try(Connection cnn = DriverManager.getConnection(cnnString);
            PreparedStatement statement = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
           ResultSet rs = null;
           statement.execute();
       }catch(SQLException e){
           e.printStackTrace();
           throw e;
       }
    }
}
