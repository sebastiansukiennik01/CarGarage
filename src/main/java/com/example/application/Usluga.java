package com.example.application;

public class Usluga {
    /**
     * Class represntanig a Service performed by Car Garge. Contains values:
     * idUslugi - service identification number
     * nazwa - name of the service
     * koszt - price of the service
     */
    //fields
    int idUslugi;
    String nazwa;
    double koszt;

    //accessors
    /**
     * Returns service identification number
     * @return Integear idUslugi
     */
    public int getIdUslugi() { return idUslugi; }

    /**
     * Sets services identification number
     * @param idUslugi
     */
    public void setIdUslugi(int idUslugi) { this.idUslugi = idUslugi; }

    /**
     * Returns service name
     * @return String nazwa
     */
    public String getNazwa() { return nazwa; }

    /**
     * Sets service name
     * @param nazwa
     */
    public void setNazwa(String nazwa) { this.nazwa = nazwa;}

    /**
     * Returns price of the service
     * @return Double koszt
     */
    public double getKoszt() { return koszt; }

    /**
     * Sets services price
     * @param koszt
     */
    public void setKoszt(double koszt) { this.koszt = koszt; }

    //constructors
    /**
     * Creates an object of the class from service name and service price.
     * @param nazwa - name of the service
     * @param koszt - price of the service
     */
    public Usluga(String nazwa, double koszt) {
        this.nazwa = nazwa;
        this.koszt = koszt;
    }

    /**
     * Creates an object of the class from service name and service price.
     * @param idUslugi - services identification number
     * @param nazwa - name of the service
     * @param koszt - price of the service
     */
    public Usluga(int idUslugi, String nazwa, double koszt) {
        this.idUslugi = idUslugi;
        this.nazwa = nazwa;
        this.koszt = koszt;
    }



}
