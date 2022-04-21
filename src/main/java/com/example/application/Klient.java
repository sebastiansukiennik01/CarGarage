package com.example.application;

import java.util.regex.Pattern;

public class Klient {
    String imie;
    String nazwisko;
    String nrTelefonu;
    Samochody carList;

    Pattern patternnumber = Pattern.compile("^\\d{9}$");

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) throws WrongNumberException {
        if(patternnumber.matcher(nrTelefonu).matches())
            this.nrTelefonu = nrTelefonu;
        else
            throw new WrongNumberException("Provided an incorrect number! The phone number should consist of 9 digits!");
    }


    public Samochody getCarList() {
        return carList;
    }

    public void setCarList(Samochody carList) {
        this.carList = carList;
    }

    public Klient(String imie, String nazwisko, String nrTelefonu) throws WrongNumberException {
        setImie(imie);
        setNazwisko(nazwisko);
        setNrTelefonu(nrTelefonu);
    }


}

