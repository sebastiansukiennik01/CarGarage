package com.example.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Produkty {

    //fields
    List<Produkt> produktList;

    //accessors
    public List<Produkt> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<Produkt> produktList) {
        this.produktList = produktList;
    }

    //constructors
    public Produkty() {
        this.produktList = new ArrayList<>();
    }

    public Produkty(ArrayList<Produkt> produktList){
        this.produktList = produktList;
    }

    //methods
    public void addProducts(Produkt p){
        produktList.add(p);
    }

    public void removeProduct(Produkt p){
        produktList.remove(p);
    }

    public void removeProduct(Integer productId){
        Optional<Produkt> productToRemove = produktList.stream().filter(
                product -> product.getNrProduktu() == productId
        ).findFirst();
        if(productToRemove.isPresent()){
            produktList.remove(productToRemove);
        }
    }
}
