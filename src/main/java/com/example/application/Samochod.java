package com.example.application;


public class Samochod {
    public enum markaEnum {Ford, Fiat, Opel, Audi, Ferrari}
    String nrRejstracyjny;
    String rocznik;
    String model;
    markaEnum marka;


    public String getNrRejstracyjny() {
        return nrRejstracyjny;
    }

    public void setNrRejstracyjny(String nrRejstracyjny) {
        this.nrRejstracyjny = nrRejstracyjny;
    }

    public String getRocznik() {
        return rocznik;
    }

    public void setRocznik(String rocznik) {
        this.rocznik = rocznik;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Samochod.markaEnum getMarka() {
        return marka;
    }

    public void setMarka(Samochod.markaEnum marka) {
        this.marka = marka;
    }

    public Samochod(String nrRejstracyjny, String rocznik, String model, Samochod.markaEnum marka) {
        this.nrRejstracyjny = nrRejstracyjny;
        this.rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
