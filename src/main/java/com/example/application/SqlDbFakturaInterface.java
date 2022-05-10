package com.example.application;

public interface SqlDbFakturaInterface {
    void insertInvoice(Faktura invoice, String date);
    void removeInvoice(Faktura invoice);
}
