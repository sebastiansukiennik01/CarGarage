package com.example.application;

import java.util.ArrayList;
import java.util.Optional;

public class Klienci implements KlienciInterface {
    public ArrayList<Klient> klientList;

    //accessors
    public ArrayList<Klient> getKlientList() {
        return klientList;
    }
    public void setKlientList(ArrayList<Klient> klientList) {
        this.klientList = klientList;
    }

    //constructors
    public Klienci() {
        this.klientList = new ArrayList<>();
    }
    public Klienci(ArrayList<Klient> klientList) {
        this.klientList = klientList;
    }

    //methods
    public void dodajKlienta(Klient klient) throws CustomerExistsException {
        for(Klient k : klientList){
            if (k.getNrTelefonu().equals(klient.nrTelefonu)){
                throw new CustomerExistsException("Customer with exactly the same phone number already exists. Please try again with different number!");
            }
        }
        klientList.add(klient);
    }

    public void usunKlienta(Klient k){
        klientList.remove(k);
    }

    public void usunKlienta(String nrTel){
        Optional<Klient> klientToRemove = klientList.stream().filter(
                klient -> klient.nrTelefonu.equals(nrTel)
        ).findFirst();
        if(klientToRemove.isPresent()){
            klientList.remove(klientToRemove);
        }
    }
}

