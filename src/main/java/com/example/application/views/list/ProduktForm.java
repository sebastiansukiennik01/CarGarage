package com.example.application.views.list;

import com.example.application.Produkt;
import com.example.application.Produkty;
import com.example.application.SqlDbProdukt;
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

import java.sql.SQLException;
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

    saveBtn.addClickShortcut(Key.ENTER);
    deleteBtn.addClickShortcut(Key.ESCAPE);

    saveBtn.setWidth("250px");
    deleteBtn.setWidth("250px");

    VerticalLayout verticalLayout = new VerticalLayout(saveBtn, deleteBtn);
    verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

    return verticalLayout;
  }

  private void save(ClickEvent event) {
    try{
      Produkt p = new Produkt(
              this.produktNameTxt.getValue(),
              this.iloscNmb.getValue(),
              this.cenaNmb.getValue(),
              this.jednostkaCmb.getValue());

      SqlDbProdukt.insertProdukt(p);
      ProduktView.products.addProducts(p);
      ProduktView.grid.setItems(ProduktView.products.getProduktList());

      Notification.show("Succesfully added: " + this.produktNameTxt.getValue() + " " + this.iloscNmb.getValue() + " "  + this.cenaNmb.getValue() + "/" + this.jednostkaCmb.getValue());
    }catch (SQLException e){
      Notification.show("Failed to save product " + produktNameTxt.getValue() + ". Please try again!");
    }catch (Exception e){
      Notification.show("An error occurred. Please restart the application and try again!");
    }
  }

  private void remove(ClickEvent event) {
    try {
      String message = "";
      Set<Produkt> selected = ProduktView.grid.getSelectedItems();
      if (selected.size() > 0) {
        for (Produkt p : selected) {
          try{
            SqlDbProdukt.removeProduct(p);
            ProduktView.products.removeProduct(p);
            message = message.concat(p.getNrProduktu() + " " + p.getNazwa() + " " + p.getIlosc() + " " + p.getCena() + "/" + p.getJednostka() + "\n");
            ProduktView.grid.setItems(ProduktView.products.getProduktList());
            Notification.show("Successfully deleted: " + message);
          }catch (SQLException e){
            Notification.show("Failed to remove product " + produktNameTxt.getValue() + ". Please try again!");
          }
        }
      }
    } catch (Exception e){
      Notification.show("An error occurred. Please restart the application and try again!");
    }

  }
}