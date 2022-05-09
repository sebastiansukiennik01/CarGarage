package com.example.application;

import com.vaadin.flow.component.charts.events.SeriesAfterAnimateEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;


public class Klient {
    String imie;
    String nazwisko;
    String nrTelefonu;
    List<Samochod> samochody;

    Samochody cars;



    //accessors
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

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochod> samochody) {
        this.samochody = samochody;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) throws WrongNumberException {
        Pattern patternnumber = Pattern.compile("^\\d{9}$");
        if(patternnumber.matcher(nrTelefonu).matches())
            this.nrTelefonu = nrTelefonu;
        else
            throw new WrongNumberException("Provided an incorrect number! The phone number should consist of 9 digits!");
    }


    public Samochody getCars() {
        return cars;
    }

    public void setCars(Samochody cars) {
        this.cars = cars;
    }

    //constructors
    public Klient(String imie, String nazwisko, String nrTelefonu) throws WrongNumberException {
        setImie(imie);
        setNazwisko(nazwisko);
        setNrTelefonu(nrTelefonu);
        this.cars = new Samochody();
    }


}

