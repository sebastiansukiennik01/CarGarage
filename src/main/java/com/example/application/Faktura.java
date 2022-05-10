package com.example.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Faktura {
    /**
     * Class represntanig and Invoice. Contains values:
     * idFaktury - invoices identification number
     * klient - Klient class object
     * samochod - Samochod class object
     * listaUslug - List of services, that should be included on the invoice
     */

    //fields
    static int idFaktury;
    Klient klient;
    Samochod samochod;
    List<Usluga> listaUslug;

    //accessors
    /**
     * Returns invoice identification number
     * @return Integear idFaktury
     */
    public static int getIdFaktury() {
        return idFaktury;
    }

    /**
     * Sets invoice identification number
     * @param idFaktury
     */
    public static void setIdFaktury(int idFaktury) {
        Faktura.idFaktury = idFaktury;
    }

    /**
     * Returns invoices client to which the invoice is assigned
     * @return Klient klient
     */
    public Klient getKlient() {
        return klient;
    }

    /**
     * Sets client to which to invoice should be assigned
     * @param klient object of class Klient
     */
    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    /**
     * Returns invoices car to which the invoice is assigned
     * @return Samochod samochod
     */
    public Samochod getSamochod() {
        return samochod;
    }

    /**
     * Sets car to which to invoice should be assigned
     * @param samochod object of class Klient
     */
    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    /**
     * Returns list of services which are included on the invoice
     * @return List listaUslug
     */
    public List<Usluga> getListaUslug() {
        return listaUslug;
    }

    /**
     * Sets list of services which should be included on the invoice
     * @param listaUslug object of class Klient
     */
    public void setListaUslug(List<Usluga> listaUslug) {
        this.listaUslug = listaUslug;
    }

    //constructors

    /**
     * Constructor that creates object of class Faktura with assigned client and car to it.
     * @param klient Client to which the invoice should be assigned
     * @param samochod Car to which the invoice should be assigned
     */
    public Faktura(Klient klient, Samochod samochod) {
        setIdFaktury(getIdFaktury() + 1);
        this.klient = klient;
        this.samochod = samochod;
        this.listaUslug = new ArrayList<>();
    }

    //methods

    /**
     * Adds service to list of services on the invoice
     * @param u Service to be added to the invoice
     */
    public void dodajUsluge(Usluga u){
        listaUslug.add(u);
    }

    /**
     * Removes service from the list of services that are included on the invoice
     * @param u Service to be removed from invoice
     */
    public void usunUsluge(Usluga u){
        listaUslug.remove(u);
    }


}
