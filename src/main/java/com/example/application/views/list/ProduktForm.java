package com.example.application.views.list;

import com.example.application.Produkt;
import com.example.application.Produkty;
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

public class ProduktForm extends FormLayout {
  H2 naglowek = new H2("Dodaj produkt");
  TextField produktNameTxt = new TextField("Nazwa");
  NumberField iloscNmb = new NumberField("Ilość");
  NumberField cenaNmb = new NumberField("Cena");
  ComboBox<Produkt.jednostkaEnum> jednostkaCmb = new ComboBox<>("Jednostka");
  Button saveBtn = new Button("Dodaj", this::save);
  Button deleteBtn = new Button("Usuń", this::remove);
  Button closeBtn = new Button("Anuluj", this::cancel);

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

  private void save(ClickEvent event) {
    try{
      Produkt p = new Produkt(this.produktNameTxt.getValue(),
              this.iloscNmb.getValue(),
              this.cenaNmb.getValue(),
              this.jednostkaCmb.getValue());

      ProduktView.productsList.addProducts(p);
      ProduktView.grid.setItems(ProduktView.productsList.getProduktList());

      Notification.show("Succesfully added: " + this.produktNameTxt.getValue() + " " + this.iloscNmb.getValue() + " "  + this.cenaNmb.getValue() + "/" + this.jednostkaCmb.getValue());
    }catch (Exception e){
      Notification.show("An error occured. Please try again");
    }
  }

  private void remove(ClickEvent event) {
    try{
      String message = "";
      Set<Produkt> selected = ProduktView.grid.getSelectedItems();
      Notification.show(selected.toString());
      if (selected.size() > 0){
        for(Produkt p : selected){
          ProduktView.productsList.removeProduct(p);
          message = message.concat(p.getNrProduktu() + " " + p.getNazwa() + " " + p.getIlosc() + " "  + p.getCena() + "/" + p.getJednostka() + "\n");
        }
        ProduktView.grid.setItems(ProduktView.productsList.getProduktList());
      }
      Notification.show("Succesfully deleted: " + message);
    }catch (Exception e){
      Notification.show("An error occured. Please try again");
    }

  }

  private void cancel(ClickEvent event) {
    String nazwa = this.produktNameTxt.getValue();
    String ilosc = String.valueOf(this.iloscNmb.getValue());
    String cena = String.valueOf(this.cenaNmb.getValue());
    Produkt.jednostkaEnum jednostka = this.jednostkaCmb.getValue();

    Notification.show(nazwa + " " + ilosc + " " + cena + " " + jednostka);
  }

}