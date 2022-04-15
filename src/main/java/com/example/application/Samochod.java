package com.example.application;

public class Samochod {
    public enum marka{Ford,Fiat,Opel,Audi,Ferrari}
    String nazwa;
    String nrRejstracyjny;
    int rocznik;
    String model;
    marka marka;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNrRejstracyjny() {
        return nrRejstracyjny;
    }

    public void setNrRejstracyjny(String nrRejstracyjny) {
        this.nrRejstracyjny = nrRejstracyjny;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Samochod.marka getMarka() {
        return marka;
    }

    public void setMarka(Samochod.marka marka) {
        this.marka = marka;
    }

    public Samochod(String nazwa, String nrRejstracyjny, int rocznik, String model, Samochod.marka marka) {
        this.nazwa = nazwa;
        this.nrRejstracyjny = nrRejstracyjny;
        this.rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
