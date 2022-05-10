package com.example.application;

public class Produkt {
    /**
     * Class representing a Product. Contains values:
     * nrProduktu - products identification number
     * nazwa - products name
     * ilosc - products quantity
     * cena - products price
     * jednostka - products unit of measurement
     */
    //fields
    public enum jednostkaEnum {kg, litr, sztuka}
    int nrProduktu = 0;
    String nazwa;
    double ilosc;
    double cena;
    jednostkaEnum jednostka;

    //accessors
    /**
     * Returns products identification number
     * @return Integear idUslugi
     */
    public int getNrProduktu() {
        return nrProduktu;
    }

    /**
     * Sets products identification number
     * @param nrProduktu
     */
    public void setNrProduktu(int nrProduktu) {
        this.nrProduktu = nrProduktu;
    }

    /**
     * Returns products name
     * @return String nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Sets products name
     * @param nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Returns products quantity
     * @return Double ilos
     */
    public double getIlosc() {
        return ilosc;
    }

    /**
     * Sets products quantity
     * @param ilosc
     */
    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * Returns products price
     * @return Double cena
     */
    public double getCena() {
        return cena;
    }

    /**
     * Sets products price
     * @param cena
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     * Returns products unit of measure
     * @return Produkt.jednostkaEnum jednostka
     */
    public Produkt.jednostkaEnum getJednostka() {
        return jednostka;
    }

    /**
     * Sets products unit of measure
     * @param jednostka
     */
    public void setJednostka(Produkt.jednostkaEnum jednostka) {
        this.jednostka = jednostka;
    }

    //constructors
    public Produkt(){}

    /**
     * Creates an object of the class, from product identification number, name, quantity, price and unit of measurement.
     * @param ProductID - products identification number
     * @param nazwa - products name
     * @param ilosc - quantity of the product
     * @param cena - products price
     * @param jednostka - products unit of measurement
     */
    public Produkt(int ProductID, String nazwa, double ilosc, double cena, Produkt.jednostkaEnum jednostka) {
        this.nrProduktu = ProductID;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }

    /**
     * Creates an object of the class, from product identification number, name, quantity, price and unit of measurement.
     * @param nazwa - products name
     * @param ilosc - quantity of the product
     * @param cena - products price
     * @param jednostka - products unit of measurement
     */
    public Produkt(String nazwa, double ilosc, double cena, Produkt.jednostkaEnum jednostka) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jednostka = jednostka;
    }

}
