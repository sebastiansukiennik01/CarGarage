package com.example.application.views.list;

import com.example.application.Klienci;
import com.example.application.Klient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Car Garage")
@Route(value = "klient-view", layout = MainLayout.class)
public class KlientView extends VerticalLayout {

    public KlientView(){
        H2 klienci = new H2("Klienci");
        klienci.getStyle().set("margin", "0 auto 0 0");
        add(klienci);

        Button addUser = new Button("Dodaj klienta");
        addUser.setAutofocus(true);
        add(addUser);

        HorizontalLayout header = new HorizontalLayout(klienci, addUser);
        header.setAlignItems(FlexComponent.Alignment.CENTER); // wydaje mi sie że powinno tak ładnie to ułożyc ale coś niedziła
        header.getThemeList().clear();
        add(header);

        Button editProfile = new Button("Edytuj Klienta");
        editProfile.setEnabled(false);
        editProfile.setAutofocus(true); // możliwość zatwierdzeniam enter gdy jest focus
        add(editProfile);

        Button usluga = new Button("Dodaj usluge");
        usluga.setEnabled(false);
        usluga.setAutofocus(true);
        add(usluga);

        Button samochody = new Button("Pokaż samochody");
        samochody.setEnabled(false);
        samochody.setAutofocus(true);
        add(samochody);

        Button delete = new Button("Usuń");
        delete.setEnabled(false);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR); // na czerwono
        //delete.getStyle().set("margin-inline-start", "auto"); //nic u nas nie zmienia chyba
        delete.setAutofocus(true);
        add(delete);

        Grid<Klient> grid = new Grid<>(Klient.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Klient::getImie).setHeader("Imie");
        grid.addColumn(Klient::getNazwisko).setHeader("Nazisko");
        grid.addColumn(Klient::getNrTelefonu).setHeader("numer telefonu");
        grid.addSelectionListener(selection -> {
            int size = selection.getAllSelectedItems().size();
            boolean isSingleSelection = size == 1; // prawda gdy 1 zaznaczony
            editProfile.setEnabled(isSingleSelection); // daje możliwośc użycia gdy zaznaczony 1
            usluga.setEnabled(isSingleSelection);
            samochody.setEnabled(isSingleSelection);

            delete.setEnabled(size != 0);
        });
        Klienci kl = new Klienci();
        kl.dodajKlienta(new Klient("Adam","Lacd","999000999"));
        kl.dodajKlienta(new Klient("Adams","Lacd","999000999"));
        kl.dodajKlienta(new Klient("Adamy","Lacd","999000999"));
        grid.setItems(kl.klientList);
        add(grid);
        HorizontalLayout footer = new HorizontalLayout(editProfile, usluga, samochody, delete);
        footer.getStyle().set("flex-wrap", "wrap");
        add(footer);
    }
}
