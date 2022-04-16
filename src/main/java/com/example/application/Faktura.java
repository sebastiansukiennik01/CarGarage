package com.example.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Faktura {

    static int idFaktury;
    Klient klient;
    Samochod samochod;
    List<Usluga> listaUslug;
    HashMap<Produkt, Double> listaProduktow;  //Key: produkt, Value: ilość produktu

    public static int getIdFaktury() {
        return idFaktury;
    }

    public static void setIdFaktury(int idFaktury) {
        Faktura.idFaktury = idFaktury;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public List<Usluga> getListaUslug() {
        return listaUslug;
    }

    public void setListaUslug(List<Usluga> listaUslug) {
        this.listaUslug = listaUslug;
    }

    public HashMap<Produkt, Double> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(HashMap<Produkt, Double> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }

    public Faktura(Klient klient, Samochod samochod) {
        setIdFaktury(getIdFaktury() + 1);
        this.klient = klient;
        this.samochod = samochod;
        this.listaUslug = new ArrayList<>();
        this.listaProduktow = new HashMap<>();
    }

    public void dodajUsluge(Usluga u){
        listaUslug.add(u);
    }
    public void dodajProdukt(Produkt p, Double i){
        listaProduktow.put(p, i);
    }

    public void usunUsluge(Usluga u){
        listaUslug.remove(u);
    }

    public void usunProdukt(Produkt p){
        listaProduktow.remove(p);
    }


}
