package com.example.application.views.list;

import com.example.application.Produkt;
import com.example.application.Usluga;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Set;

public class UslugiForm extends FormLayout {
    H2 naglowek = new H2("Dodaj usługę");
    TextField nameTxt = new TextField("Nazwa");
    NumberField priceNmb = new NumberField("Koszt");
    Button zatwierdzBtn = new Button("Dodaj", this::save);
    Button usunBtn = new Button("Usun", this::remove);

    public UslugiForm(){
        addClassName("uslugi-form");
        add(naglowek, nameTxt, priceNmb, createButtonsLayout());
    }

    public VerticalLayout createButtonsLayout(){
        zatwierdzBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        usunBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);

        zatwierdzBtn.setWidth(nameTxt.getWidth());
        usunBtn.setWidth(nameTxt.getWidth());

        zatwierdzBtn.setWidth("250px");
        usunBtn.setWidth("250px");

        VerticalLayout verticalLayout = new VerticalLayout(zatwierdzBtn, usunBtn);
        verticalLayout.setAlignItems(Alignment.CENTER);

        return verticalLayout;
    }

    private void save(ClickEvent event) {
        try{
            Usluga u = new Usluga(this.nameTxt.getValue(),
                    this.priceNmb.getValue());

            UslugiView.uslugiList.addUsluga(u);
            UslugiView.grid.setItems(UslugiView.uslugiList.getUslugiList());

            Notification.show("Succesfully added: " + this.nameTxt.getValue() + " " + this.priceNmb.getValue());
        }catch (Exception e){
            Notification.show("An error occured. Please try again");
        }
    }

    private void remove(ClickEvent event) {
        try{
            String message = "";
            Set<Usluga> selected = UslugiView.grid.getSelectedItems();
            Notification.show(selected.toString());
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
