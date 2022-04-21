package com.example.application;

public class Samochod {
    public enum marka{Ford,Fiat,Opel,Audi,Ferrari}
    String nrRejstracyjny;
    int rocznik;
    String model;
    marka marka;


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

    public Samochod(String nrRejstracyjny, int rocznik, String model, Samochod.marka marka) {
        this.nrRejstracyjny = nrRejstracyjny;
        this.rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
