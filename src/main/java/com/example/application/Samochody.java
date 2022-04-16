package com.example.application;

import java.util.ArrayList;
import java.util.Optional;

public class Samochody {

    //fields
    ArrayList<Samochod> samochodList;

    //accessors
    public ArrayList<Samochod> getSamochodList() {
        return samochodList;
    }

    public void setSamochodList(ArrayList<Samochod> samochodList) {
        this.samochodList = samochodList;
    }

    //constructors
    public Samochody() {
        this.samochodList = new ArrayList<>();
    }

    public Samochody(ArrayList<Samochod> samochodList) {
        this.samochodList = samochodList;
    }

    //methods
    public void addSamochod(Samochod s){
        samochodList.add(s);
    }

    public void removeSamochod(Samochod s){
        samochodList.remove(s);
    }

    public void removeSamochod(String nrRej){
        Optional<Samochod> samochodToRemove = samochodList.stream().filter(
                samochod -> samochod.getNrRejstracyjny().equals(nrRej)
        ).findFirst();
        if(samochodToRemove.isPresent()){
            samochodList.remove(samochodToRemove);
        }
    }

}
