package com.example.application.views.list;

import com.example.application.Produkt;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class ProduktForm extends FormLayout {
  H2 naglowek = new H2("Dodaj produkt");
  TextField produktNameTxt = new TextField("Nazwa");
  NumberField iloscNmb = new NumberField("Ilość");
  NumberField cenaNmb = new NumberField("Cena");
  ComboBox<Produkt.jednostkaEnum> jednostkaCmb = new ComboBox<>("Jednostka");
  Button saveBtn = new Button("Zapisz");
  Button deleteBtn = new Button("Usuń");
  Button closeBtn = new Button("Anuluj");

  public ProduktForm() {
    addClassName("contact-form");
    jednostkaCmb.setItems(Produkt.jednostkaEnum.values());

    add(naglowek,
            produktNameTxt,
            iloscNmb,
            cenaNmb,
            jednostkaCmb,
            createButtonsLayout());
  }

  private VerticalLayout createButtonsLayout() {
    saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    deleteBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
    closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

    saveBtn.addClickShortcut(Key.ENTER);
    deleteBtn.addClickShortcut(Key.ESCAPE);

    saveBtn.setWidth("250px");
    deleteBtn.setWidth("250px");
    closeBtn.setWidth("250px");

    VerticalLayout verticalLayout = new VerticalLayout(saveBtn, deleteBtn, closeBtn);
    verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

    return verticalLayout;
  }
}