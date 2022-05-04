package com.example.application.views.list;

import com.example.application.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Dial;
import com.vaadin.flow.component.charts.model.Position;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@PageTitle("Car Garage")
@Route(value = "klient-view", layout = MainLayout.class)
public class KlientView extends VerticalLayout {

    /*
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
     */

    static Grid<Klient> grid = new Grid<>(Klient.class, false);
    static Klienci klienciList = new Klienci(); //tutaj musi być productList = cała lista produktów z bazy danych
    KlientForm klientForm;

    //for Samochod dialog window
    static Grid<Samochod> samochodGrid = new Grid<>(Samochod.class);
    static Samochody samochodyList = new Samochody();
    static Dialog dialog;

    SamochodForm samochodForm;

    //accessors
    public Grid<Klient> getGrid() {
        return grid;
    }

    public void setGrid(Grid<Klient> grid) {
        KlientView.grid = grid;
    }

    public Grid<Samochod> getSamochodGrid() {
        return samochodGrid;
    }

    public void setSamochodGrid(Grid<Samochod> samochodGrid) {
        KlientView.samochodGrid = samochodGrid;
    }


    public KlientView(){
        addClassName("klient-view");
        setSizeFull();
        configureForm();
        configureGrid();
        add(new H1("Klienci"));
        add(getContent());
    }

    private HorizontalLayout getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, klientForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, klientForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        if (getGrid().getColumns().isEmpty()){
            grid.addClassNames("klient-grid");
            grid.setSizeFull();
            grid.setSelectionMode(Grid.SelectionMode.MULTI);
            grid.addColumn(Klient::getImie).setHeader("Name").setSortable(true);
            grid.addColumn(Klient::getNazwisko).setHeader("Surname").setSortable(true);
            grid.addColumn(Klient::getNrTelefonu).setHeader("Phone number").setSortable(true);
            grid.addColumn(
                    new ComponentRenderer<>(Button::new, (button, person) -> {
                        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                        button.addClickListener(e -> this.showCustomersCars(person));
                        button.setText("Show cars");
                    })).setHeader("Manage");
            grid.getColumns().forEach(col -> col.setAutoWidth(true));
        }
    }

    public void configureForm(){
        addClassName("klient-form");
        klientForm = new KlientForm();
        klientForm.setWidth("250px");
    }

    private void showCustomersCars(Klient klient) {
        dialog = new Dialog();
        //samochodyList = klient.getCars();

        configureCarForm(); //sets up carForm
        configureCarGrid(klient);  //sets up carGrid
        dialog.add(new H1("Customers cars"));

        dialog.setWidth("1250px");
        dialog.add(getCarContent());  //adds grid and form to the dialog window
        dialog.open();
    }

    public HorizontalLayout getCarContent(){
        HorizontalLayout content = new HorizontalLayout(samochodGrid, samochodForm);
        content.setSizeFull();
        return content;
    }

    public void configureCarGrid(Klient klient) {
        samochodGrid = new Grid<>(Samochod.class);  //resets the grid (creates new one)
        samochodGrid.setHeight("1000px");
        samochodGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        //ArrayList<Samochod> customerCars = klient.getCars().getSamochodList();
        //samochodGrid.setItems(customerCars);

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

    }

    public void configureCarForm(){
        samochodForm = new SamochodForm();
        samochodForm.setWidth("200px");
    }
}