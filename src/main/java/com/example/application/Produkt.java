package com.example.application;

public class Produkt {
    public enum jednostka {kg, litr, szt}
    static int nrProduktu = 0;
    String nazwa;
    double ilosc;
    double cena;
    jednostka jednostka;

    public int getNrProduktu() {
        return nrProduktu;
    }

    public static void setNrProduktu(int nrProduktu) {
        Produkt.nrProduktu = nrProduktu;
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

    public Produkt(String nazwa, double ilosc, double cena, Produkt.jednostka jednostka) {
        setNrProduktu(getNrProduktu() + 1);
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }
}
