package com.example.application;

import java.util.Optional;

public interface KlienciInterface {

    void dodajKlienta(Klient klient) throws CustomerExistsException;

    void usunKlienta(Klient k);

    void usunKlienta(String nrTel);
}
