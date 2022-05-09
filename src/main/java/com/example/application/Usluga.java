package com.example.application;

public class Usluga {

    public static int idUslugi = 1;
    String nazwa;
    double koszt;

    public static int getIdUslugi() { return idUslugi; }

    public static void setIdUslugi(int idUslugi) { Usluga.idUslugi = idUslugi; }

    public String getNazwa() { return nazwa; }

    public void setNazwa(String nazwa) { this.nazwa = nazwa;}

    public double getKoszt() { return koszt; }

    public void setKoszt(double koszt) { this.koszt = koszt; }


    public Usluga(String nazwa, double koszt) {
        setIdUslugi(getIdUslugi() + 1);
        this.nazwa = nazwa;
        this.koszt = koszt;
    }



}
