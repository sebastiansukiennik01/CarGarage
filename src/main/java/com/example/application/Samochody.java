package com.example.application;


import java.util.ArrayList;
import java.util.Optional;

public class Samochody {

    //fields
    ArrayList<Samochod> samochodList = new ArrayList<>();

    //accessors
    public ArrayList<Samochod> getSamochodList() {
        return samochodList;
    }

    public void setSamochodList(ArrayList<Samochod> samochodList) {
        this.samochodList = samochodList;
    }

    //constructors
    public Samochody() {
    }

    public Samochody(ArrayList<Samochod> samochodList) {
        this.samochodList = samochodList;
    }

    //methods
    public void addSamochod(Samochod samochod) throws CarExistsException{

        for(Samochod s : samochodList){
            if (s.getNrRejstracyjny().equals(samochod.getNrRejstracyjny())){
                throw new CarExistsException("Car with exactly the same registration number already exists. Please try again with different number!");
            }
        }
        samochodList.add(samochod);
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
