package com.example.application;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Samochod {
    public enum markaEnum {Ford, Fiat, Opel, Audi, Ferrari}
    @Id
    String nrRejstracyjny;
    int rocznik;
    String model;
    markaEnum marka;


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

    public Samochod.markaEnum getMarka() {
        return marka;
    }

    public void setMarka(Samochod.markaEnum marka) {
        this.marka = marka;
    }

    public Samochod(String nrRejstracyjny, int rocznik, String model, Samochod.markaEnum marka) {
        this.nrRejstracyjny = nrRejstracyjny;
        this.rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
