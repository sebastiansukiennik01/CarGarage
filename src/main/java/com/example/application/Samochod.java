package com.example.application;


public class Samochod {
    /**
     * Class represntanig an instance of a Car. Contains values:
     * nrRejestracyjny - cars registration number
     * rocznik - build year
     * model - car model
     * marka - car brand
     */
    //fields
    public enum markaEnum {Ford, Fiat, Opel, Audi, Ferrari}
    String nrRejstracyjny;
    String rocznik;
    String model;
    markaEnum marka;

    //accessors
    /**
     * Returns cars registration number
     * @return String nrRejstracyjny
     */
    public String getNrRejstracyjny() {
        return nrRejstracyjny;
    }

    /**
     * Sets cars registration number
     * @param nrRejstracyjny
     */
    public void setNrRejstracyjny(String nrRejstracyjny) {
        this.nrRejstracyjny = nrRejstracyjny;
    }

    /**
     * Returns cars build year
     * @return String rocznik
     */
    public String getRocznik() {
        return rocznik;
    }

    /**
     * Sets cars build year
     * @param rocznik
     */
    public void setRocznik(String rocznik) {
        this.rocznik = rocznik;
    }

    /**
     * Returns cars model
     * @return String model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets cars model
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Returns car brand
     * @return Samochod.markaEnum marka
     */
    public Samochod.markaEnum getMarka() {
        return marka;
    }

    /**
     * Sets car brand
     * @param marka
     */
    public void setMarka(Samochod.markaEnum marka) {
        this.marka = marka;
    }

    //accessors
    /**
     * Creates an object of the class from service name and service price.
     * @param nrRejstracyjny - registration number
     * @param rocznik - build year
     * @param model - car model
     * @param marka - car bran
     */
    public Samochod(String nrRejstracyjny, String rocznik, String model, Samochod.markaEnum marka) {
        this.nrRejstracyjny = nrRejstracyjny;
        this.rocznik = rocznik;
        this.model = model;
        this.marka = marka;
    }
}
