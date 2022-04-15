package com.example.application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Klient {
    String imie;
    String nazwisko;
    int nrTelefonu;

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

    public Integer getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(Integer nrTelefonu) {
        if(patternnumber.matcher(nrTelefonu.toString()).matches())
            this.nrTelefonu = nrTelefonu;
    }
    public Klient(String imie, String nazwisko, Integer nrTelefonu) {
        setImie(imie);
        setNazwisko(nazwisko);
        setNrTelefonu(nrTelefonu);
    }


}

