package com.example.application.views.list;

import com.example.application.*;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import jdk.jshell.spi.ExecutionControlProvider;

import java.util.ArrayList;
import java.util.List;
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

            KlientView.klienciList.dodajKlienta(k);

            KlientView.grid.setItems(KlientView.klienciList.getKlientList());

            Notification.show("Succesfully added: " + this.imieTxt.getValue() + " " + this.nazwiskoTxt.getValue() + " " + this.nrTelefonuTxt.getValue());
        } catch (/*WrongNumberException*/  CustomerExistsException e) {
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
                    KlientView.klienciList.usunKlienta(k);
                    message = message.concat(k.getImie() + " " + k.getNazwisko() + " " + k.getNrTelefonu() + "\n");
                }
                KlientView.grid.setItems(KlientView.klienciList.getKlientList());
            }
            Notification.show("Succesfully deleted: " + message);
        } catch (Exception e) {
            Notification.show("An error occurred. Please try again");
        }

    }
}

