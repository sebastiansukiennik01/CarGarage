package com.example.application;

public class Samochod {
    public enum marka{Ford,Fiat,Opel,Audi,Ferrari}
    String nazwa;
    String nrRejstracyjny;
    int Rocznik;
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
        return Rocznik;
    }

    public void setRocznik(int rocznik) {
        Rocznik = rocznik;
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
        Rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
