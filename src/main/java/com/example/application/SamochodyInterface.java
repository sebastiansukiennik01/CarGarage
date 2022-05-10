package com.example.application;

import java.util.Optional;

public interface SamochodyInterface {

    void addSamochod(Samochod samochod) throws CarExistsException;

    void removeSamochod(Samochod s);

    void removeSamochod(String nrRej);
}
