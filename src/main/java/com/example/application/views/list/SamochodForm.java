package com.example.application.views.list;

import com.example.application.*;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
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

import java.sql.SQLException;
import java.util.Set;

public class SamochodForm extends FormLayout {

    Klient currentClient;
    H2 naglowek = new H2("Dodaj samochod");
    TextField modelTxt = new TextField("Model");
    TextField nrRejestracyjnyTxt = new TextField("Numer Rejestracyjny");
    NumberField rocznikNmb = new NumberField("Rocznik");
    ComboBox<Samochod.markaEnum> markaCmb = new ComboBox<>("Marka");
    Button zatwierdzBtn = new Button("Dodaj", this::save);
    Button usunBtn = new Button("Usun", this::remove);
    Button zamknijBtn = new Button("Zamknij", this::close);

    public SamochodForm(Klient klient){
        this.currentClient = klient;
        addClassName("uslugi-form");
        markaCmb.setItems(Samochod.markaEnum.values());

        markaCmb.setWidth("200px");
        nrRejestracyjnyTxt.setWidth("200px");
        modelTxt.setWidth("200px");
        rocznikNmb.setWidth("200px");

        VerticalLayout verticalLayout = new VerticalLayout(naglowek, nrRejestracyjnyTxt, markaCmb, modelTxt, rocznikNmb);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        add(verticalLayout, createButtonsLayout());
    }

    public VerticalLayout createButtonsLayout(){
        zatwierdzBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        usunBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        zamknijBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        zatwierdzBtn.addClickShortcut(Key.ENTER);
        usunBtn.addClickShortcut(Key.ESCAPE);

        zatwierdzBtn.setWidth("200px");
        usunBtn.setWidth("200px");
        zamknijBtn.setWidth("200px");

        VerticalLayout verticalLayout = new VerticalLayout(zatwierdzBtn, usunBtn, zamknijBtn);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        return verticalLayout;
    }

    private void save(ClickEvent event) {
        try{
            Samochod s = new Samochod(nrRejestracyjnyTxt.getValue(),
                    String.valueOf((int) Math.round(rocznikNmb.getValue())),
                    modelTxt.getValue(),
                    markaCmb.getValue());

            SqlDbSamochod.insertCar(s, this.currentClient);
            KlientView.samochodyList.addSamochod(s);
            KlientView.samochodGrid.setItems(KlientView.samochodyList.getSamochodList());

            Notification.show("Succesfully added: " + nrRejestracyjnyTxt.getValue() + " " + markaCmb.getValue() + modelTxt.getValue());
        }catch (CarExistsException e) {
            Notification.show(e.getMessage());
        }catch (SQLException e) {
            Notification.show("Failed to save product " + nrRejestracyjnyTxt.getValue() + ". Please try again!");
        }catch (Exception e){
            Notification.show("An error occurred. Please restart the application and try again!");
        }
    }

    private void remove(ClickEvent event) {
        try{
            String message = "";
            Set<Samochod> selected = KlientView.samochodGrid.getSelectedItems();
            if (selected.size() > 0){
                for(Samochod s : selected){
                    try{
                        SqlDbSamochod.removeCar(s);
                        KlientView.samochodyList.removeSamochod(s);
                        message = message.concat(s.getNrRejstracyjny() + " " + s.getMarka() + " " + s.getModel() + "\n");
                        KlientView.samochodGrid.setItems(KlientView.samochodyList.getSamochodList());
                        Notification.show("Succesfully deleted: " + message);
                    }catch (SQLException e){
                        Notification.show("Failed to remove product " + nrRejestracyjnyTxt.getValue() + ". Please try again!");
                    }
                }
            }
        }catch (Exception e){
            Notification.show("An error occurred. Please restart the application and try again!");
        }
    }

    private void close(ClickEvent event){
        KlientView.dialog.close();
    }
}
