package com.example.application.views.list;

import com.example.application.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Car Garage")
@Route(value = "klient-view", layout = MainLayout.class)
public class KlientView extends VerticalLayout {

    static Grid<Klient> grid = new Grid<>(Klient.class, false);
    public static Klienci klienci = new Klienci();
    KlientForm klientForm;

    //variables for Samochod dialog window
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

        try{
            klienci = SqlDbKlient.getClients();
            ArrayList<Klient> klienciList = klienci.getKlientList();
            if (klienciList != null)
                grid.setItems(klienciList);
        }catch (WrongNumberException e){
            Notification.show("Failed to load Clients from database! Please restart application.");
        }
    }

    public void configureForm(){
        addClassName("klient-form");
        klientForm = new KlientForm();
        klientForm.setWidth("250px");
    }

    private void showCustomersCars(Klient klient) {
        dialog = new Dialog();
        samochodyList = klient.getCars();

        configureCarForm(klient); //sets up carForm
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

        try{
            samochodGrid.setItems(SqlDbSamochod.getCars(klient.getNrTelefonu()).getSamochodList());
        }catch (Exception e){
            e.printStackTrace();
        }
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

    }

    public void configureCarForm(Klient klient){
        samochodForm = new SamochodForm(klient);
        samochodForm.setWidth("200px");
    }
}