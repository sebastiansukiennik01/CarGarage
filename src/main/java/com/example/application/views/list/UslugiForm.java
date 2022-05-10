package com.example.application.views.list;

import com.example.application.Produkt;
import com.example.application.SqlDbUsluga;
import com.example.application.Usluga;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.sql.SQLException;
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

        zatwierdzBtn.addClickShortcut(Key.ENTER);
        usunBtn.addClickShortcut(Key.ESCAPE);

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
            SqlDbUsluga.insertService(u);
            UslugiView.uslugi.addUsluga(u);
            UslugiView.grid.setItems(UslugiView.uslugi.getUslugiList());
            Notification.show("Succesfully added: " + this.nameTxt.getValue() + " " + this.priceNmb.getValue());
        }catch(SQLException e){
            Notification.show("Failed to save service " + nameTxt.getValue() + ". Please try again!");
        }
        catch (Exception e){
            Notification.show("An error occured. Please try again");
        }
    }

    private void remove(ClickEvent event) {
        try{
            String message = "";
            Set<Usluga> selected = UslugiView.grid.getSelectedItems();
            if (selected.size() > 0){
                for(Usluga u : selected){
                    try {
                        SqlDbUsluga.removeService(u);
                        UslugiView.uslugi.removeUsluga(u);
                        message = message.concat(u.getNazwa() + " " + u.getKoszt() + "\n");
                        UslugiView.grid.setItems(UslugiView.uslugi.getUslugiList());
                        Notification.show("Successfully deleted: " + message);
                    }catch (SQLException e){
                        Notification.show("Failed to remove service " + nameTxt.getValue() + ". Please try again!");
                    }
                }
            }
        }catch (Exception e){
            Notification.show("An error occurred. Please restart the application and try again!");
        }
    }
}
