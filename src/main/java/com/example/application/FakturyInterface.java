package com.example.application;

import java.util.Optional;

public interface FakturyInterface {

    void dodajFakture(Faktura f);

    void usunFakture(Faktura f);

    void removeFaktura(Integer fakturaId);
}
