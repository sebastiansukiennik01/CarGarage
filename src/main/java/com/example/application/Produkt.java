package com.example.application;

public class Produkt {
    public enum jednostkaEnum {kg, litr, sztuka}
    int nrProduktu = 0;
    String nazwa;
    double ilosc;
    double cena;
    jednostkaEnum jednostka;

    public int getNrProduktu() {
        return nrProduktu;
    }

    public void setNrProduktu(int nrProduktu) {
        this.nrProduktu = nrProduktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Produkt.jednostkaEnum getJednostka() {
        return jednostka;
    }

    public void setJednostka(Produkt.jednostkaEnum jednostka) {
        this.jednostka = jednostka;
    }

    public Produkt(){}

    public Produkt(int ProductID, String nazwa, double ilosc, double cena, Produkt.jednostkaEnum jednostka) {
        this.nrProduktu = ProductID;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }

    public Produkt(String nazwa, double ilosc, double cena, Produkt.jednostkaEnum jednostka) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }

}
