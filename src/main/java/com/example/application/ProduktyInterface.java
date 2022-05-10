package com.example.application;

import java.util.Optional;

public interface ProduktyInterface {

    void addProducts(Produkt p);

    void removeProduct(Produkt p);

    void removeProduct(Integer productId);
}
