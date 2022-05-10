package com.example.application;

import java.util.ArrayList;
import java.util.Optional;

public class Uslugi implements UslugiInterface {
    //fields
    ArrayList<Usluga> uslugiList;

    //accessors
    public ArrayList<Usluga> getUslugiList() {
        return uslugiList;
    }
    public void setUslugiList(ArrayList<Usluga> uslugiList) {
        this.uslugiList = uslugiList;
    }

    //constructors
    public Uslugi() {
        this.uslugiList = new ArrayList<>();
    }
    public Uslugi(ArrayList<Usluga> uslugiList) {
        this.uslugiList = uslugiList;
    }

    //methods
    public void addUsluga(Usluga u){
        uslugiList.add(u);
    }
    public void removeUsluga(Usluga u){
        uslugiList.remove(u);
    }
    public void removeUsluga(Integer uslugaId){
        Optional<Usluga> uslugaToRemove = uslugiList.stream().filter(
                usluga -> Usluga.getIdUslugi() == uslugaId
        ).findFirst();
        if (uslugaToRemove.isPresent()){
            uslugiList.remove(uslugaToRemove);
        }
    }

}
