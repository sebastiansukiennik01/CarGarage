package com.example.application;

import java.util.ArrayList;

public class Klienci {
    public ArrayList<Klient> klientList;

    public void dodaj(Klient klient) {
        klientList.add(klient);
    }

    public Klienci() {
        this.klientList = new ArrayList<>();
    }
}
