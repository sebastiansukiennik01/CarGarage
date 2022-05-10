package com.example.application;

import com.vaadin.flow.component.charts.events.SeriesAfterAnimateEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;


public class Klient {
    /**
     * Class represntanig a Client. Contains values:
     * imie - clients name
     * nazwisko - clients last name
     * nrTelefonu - clients phone number
     * cars - List of car, which belong (are assigned) to this client
     */
    //fields
    String imie;
    String nazwisko;
    String nrTelefonu;
    Samochody cars;

    //accessors
    /**
     * Returns clients name
     * @return String imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets clients name
     * @param imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Returns clients last name
     * @return String nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets clients last name
     * @param nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Returns clients phone number
     * @return String nrTelefonu
     */
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    /**
     * Sets clients phone number. Checks if provided phone number is correct.
     * If yes then assign it to current client, if no, then throw WrongNumberException.
     * @param nrTelefonu
     */
    public void setNrTelefonu(String nrTelefonu) throws WrongNumberException {
        Pattern patternnumber = Pattern.compile("^\\d{9}$");
        if(patternnumber.matcher(nrTelefonu).matches())
            this.nrTelefonu = nrTelefonu;
        else
            throw new WrongNumberException("Provided an incorrect number! The phone number should consist of 9 digits!");
    }

    /**
     * Returns object of type Samochody which represents all clients cars.
     * @return Samochody cars
     */
    public Samochody getCars() {
        return cars;
    }

    /**
     * Sets object of type Samochody which represents all clients cars.
     * @param cars
     */
    public void setCars(Samochody cars) {
        this.cars = cars;
    }

    //constructors
    /**
     * Creates an object of the class from name, last name and phone number.
     * @param imie - clients name
     * @param nazwisko - clients last name
     * @param nrTelefonu - clients phone number
     */
    public Klient(String imie, String nazwisko, String nrTelefonu) throws WrongNumberException {
        setImie(imie);
        setNazwisko(nazwisko);
        setNrTelefonu(nrTelefonu);
        this.cars = new Samochody();
    }
}

