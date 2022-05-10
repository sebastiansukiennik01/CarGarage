package com.example.application;

public class Usluga {

    int idUslugi;
    String nazwa;
    double koszt;

    public int getIdUslugi() { return idUslugi; }

    public void setIdUslugi(int idUslugi) { this.idUslugi = idUslugi; }

    public String getNazwa() { return nazwa; }

    public void setNazwa(String nazwa) { this.nazwa = nazwa;}

    public double getKoszt() { return koszt; }

    public void setKoszt(double koszt) { this.koszt = koszt; }

    public Usluga(String nazwa, double koszt) {
        this.nazwa = nazwa;
        this.koszt = koszt;
    }

    public Usluga(int idUslugi, String nazwa, double koszt) {
        this.idUslugi = idUslugi;
        this.nazwa = nazwa;
        this.koszt = koszt;
    }



}
