package com.example.application;

public class Produkt {
    public enum jednostka {kg,litr,szt,}
    int nrProduktu;
    String nazwa;
    double ilosc;
    double cena;
    jednostka jednostka;

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

    public Produkt.jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Produkt.jednostka jednostka) {
        this.jednostka = jednostka;
    }

    public Produkt(int nrProduktu, String nazwa, double ilosc, double cena, Produkt.jednostka jednostka) {
        this.nrProduktu = nrProduktu;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }
}
