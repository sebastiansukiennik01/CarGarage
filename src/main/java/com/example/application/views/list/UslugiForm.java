package com.example.application.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class UslugiForm extends FormLayout {
    H2 naglowek = new H2("Dodaj usługę");
    TextField nazwaTxt = new TextField("Nazwa usługi");
    NumberField kosztNmb = new NumberField("Koszt");
    Button zatwierdzBtn = new Button("Zatwierdz");
    Button usunBtn = new Button("Usun");
    Button anulujBtn = new Button("Anuluj");


    public UslugiForm(){
        addClassName("uslugi-form");
        add(naglowek, nazwaTxt, kosztNmb, createButtonsLayout());
    }

    public VerticalLayout createButtonsLayout(){
        zatwierdzBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        usunBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        anulujBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        zatwierdzBtn.setWidth(nazwaTxt.getWidth());
        usunBtn.setWidth(nazwaTxt.getWidth());
        anulujBtn.setWidth(nazwaTxt.getWidth());

        zatwierdzBtn.setWidth("250px");
        usunBtn.setWidth("250px");
        anulujBtn.setWidth("250px");

        VerticalLayout verticalLayout = new VerticalLayout(zatwierdzBtn);
        verticalLayout.setAlignItems(Alignment.CENTER);

        return verticalLayout;
    }
}
