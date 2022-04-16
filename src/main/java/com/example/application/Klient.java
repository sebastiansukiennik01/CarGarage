package com.example.application;

import java.util.regex.Pattern;

public class Klient {
    String imie;
    String nazwisko;
    String nrTelefonu;

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

    public void setNrTelefonu(String nrTelefonu) {
        if(patternnumber.matcher(nrTelefonu).matches())
            this.nrTelefonu = nrTelefonu;
    }

    public Klient(String imie, String nazwisko, String nrTelefonu) {
        setImie(imie);
        setNazwisko(nazwisko);
        setNrTelefonu(nrTelefonu);
    }


}

