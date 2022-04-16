package com.example.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Faktury {

    //fields
    List<Faktura> listaFaktur;

    //accessors
    public List<Faktura> getListaFaktur() {
        return listaFaktur;
    }

    public void setListaFaktur() {
        this.listaFaktur = new ArrayList<>();
    }

    //constructors
    public Faktury(List<Faktura> listaFaktur) {
        this.listaFaktur = listaFaktur;
    }

    public Faktury() {
        this.listaFaktur = new ArrayList<>();
    }

    //methods
    public void dodajFakture(Faktura f){
        getListaFaktur().add(f);
    }

    public void usunFakture(Faktura f){
        getListaFaktur().remove(f);
    }

    public void removeFaktura(Integer fakturaId){
        Optional<Faktura> fakturaToRemove = listaFaktur.stream().filter(
                faktura -> Faktura.getIdFaktury() == fakturaId
        ).findFirst();
        if(fakturaToRemove.isPresent()){
            listaFaktur.remove(fakturaToRemove);
        }
    }

}
