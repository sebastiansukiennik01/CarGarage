package com.example.application.views.list;

import com.example.application.Klient;
import com.example.application.Produkt;
import com.example.application.Samochod;
import com.example.application.Usluga;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Set;

public class SamochodForm extends FormLayout {
    H2 naglowek = new H2("Dodaj samochod");
    TextField modelTxt = new TextField("Model");
    TextField nrRejestracyjnyTxt = new TextField("Numer Rejestracyjny");
    NumberField rocznikNmb = new NumberField("Rocznik");
    ComboBox<Samochod.marka> markaCmb = new ComboBox<>("Jednostka");
    Button zatwierdzBtn = new Button("Dodaj", this::save);
    Button usunBtn = new Button("Usun", this::remove);

    public SamochodForm(){
        addClassName("uslugi-form");
        add(naglowek, markaCmb, modelTxt, rocznikNmb, createButtonsLayout());
    }

    public VerticalLayout createButtonsLayout(){
        zatwierdzBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        usunBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);

        zatwierdzBtn.setWidth(modelTxt.getWidth());
        usunBtn.setWidth(modelTxt.getWidth());

        zatwierdzBtn.setWidth("250px");
        usunBtn.setWidth("250px");

        VerticalLayout verticalLayout = new VerticalLayout(zatwierdzBtn, usunBtn);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        return verticalLayout;
    }

    private void save(ClickEvent event) {
        try{
            Samochod s = new Samochod(nrRejestracyjnyTxt.getValue(),
                    (int) Math.round(rocznikNmb.getValue()),
                    modelTxt.getValue(),
                    markaCmb.getValue());

            KlientView.samochodyList.addSamochod(s);
            UslugiView.grid.setItems(UslugiView.uslugiList.getUslugiList());

            //Notification.show("Succesfully added: " + this.nameTxt.getValue() + " " + this.priceNmb.getValue());
        }catch (Exception e){
            Notification.show("An error occured. Please try again");
        }
    }

    private void remove(ClickEvent event) {
        try{
            String message = "";
            Set<Usluga> selected = UslugiView.grid.getSelectedItems();
            if (selected.size() > 0){
                for(Usluga u : selected){
                    UslugiView.uslugiList.removeUsluga(u);
                    message = message.concat(u.getNazwa() + " " + u.getKoszt() + "\n");
                }
                UslugiView.grid.setItems(UslugiView.uslugiList.getUslugiList());
            }
            Notification.show("Succesfully deleted: " + message);
        }catch (Exception e){
            Notification.show("An error occured. Please try again");
        }
    }
}
