package com.example.application.views.list;

import com.example.application.*;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Set;

public class KlientForm extends FormLayout {
    H2 naglowek = new H2("Dodaj klienta");
    TextField imieTxt = new TextField("Imie");
    TextField nazwiskoTxt = new TextField("Nazwisko");
    TextField nrTelefonuTxt = new TextField("Numer telefonu");
    Button saveBtn = new Button("Dodaj", this::save);
    Button deleteBtn = new Button("Usuń", this::remove);

    public KlientForm() {
        addClassName("contact-form");
        add(naglowek,
                imieTxt,
                nazwiskoTxt,
                nrTelefonuTxt,
                createButtonsLayout());
    }

    private VerticalLayout createButtonsLayout() {
        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);

        saveBtn.addClickShortcut(Key.ENTER);
        deleteBtn.addClickShortcut(Key.ESCAPE);

        saveBtn.setWidth("250px");
        deleteBtn.setWidth("250px");

        VerticalLayout verticalLayout = new VerticalLayout(saveBtn, deleteBtn);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        return verticalLayout;
    }

    private void save(ClickEvent event) {
        try {
            Klient k = new Klient(this.imieTxt.getValue(),
                    this.nazwiskoTxt.getValue(),
                    this.nrTelefonuTxt.getValue());

            SqlDbKlient.insertKlient(k);        //inserts client to database
            KlientView.klienci.dodajKlienta(k);  // add client to local variable, to not call the database again
            KlientView.grid.setItems(KlientView.klienci.getKlientList()); //update the greed with new klient list

            Notification.show("Succesfully added: " + this.imieTxt.getValue() + " " + this.nazwiskoTxt.getValue() + " " + this.nrTelefonuTxt.getValue());
        } catch (WrongNumberException | CustomerExistsException e) {
            Notification.show(e.getMessage());
        } catch(Exception e){
            Notification.show("An error occurred. Please try again");
        }
    }

    private void remove(ClickEvent event) {
        try {
            String message = "";
            Set<Klient> selected = KlientView.grid.getSelectedItems();
            if (selected.size() > 0) {
                for (Klient k : selected) {
                    SqlDbKlient.removeKlient(k); //removes client from database
                    KlientView.klienci.usunKlienta(k); //remove klient from local klient List
                    message = message.concat(k.getImie() + " " + k.getNazwisko() + " " + k.getNrTelefonu() + "\n");
                }
                KlientView.grid.setItems(KlientView.klienci.getKlientList());  //update the grid with new klient List
                Notification.show("Succesfully deleted: " + message);
            }else{
                Notification.show("No records selected. Please try again.");
            }
        } catch (Exception e) {
            Notification.show("An error occurred. Please try again");
        }

    }
}

