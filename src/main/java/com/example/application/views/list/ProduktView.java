package com.example.application.views.list;

import com.example.application.Klient;
import com.example.application.Produkt;
import com.example.application.Produkty;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.validation.constraints.Null;
import java.util.stream.Stream;

@Route(value = "produkt-view", layout = MainLayout.class)
public class ProduktView extends VerticalLayout {

    static Grid<Produkt> grid = new Grid<>(Produkt.class, false);
    static Produkty productsList = new Produkty(); //tutaj musi być productList = cała lista produktów z bazy danych
    ProduktForm produktForm;

    public Grid<Produkt> getGrid() {
        return grid;
    }

    public void setGrid(Grid<Produkt> grid) {
        ProduktView.grid = grid;
    }

    public ProduktView(){
        addClassName("produkt-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(new H1("Produkty"));
        add(getContent());
    }

    private HorizontalLayout getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, produktForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, produktForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        if (getGrid().getColumns().isEmpty()){
            grid.addClassNames("produkt-grid");
            grid.setSizeFull();
            grid.setSelectionMode(Grid.SelectionMode.MULTI);
            grid.addColumn(Produkt::getNazwa).setHeader("Name").setSortable(true);
            grid.addColumn(Produkt::getIlosc).setHeader("Quantity").setSortable(true);
            grid.addColumn(Produkt::getCena).setHeader("Price").setSortable(true);
            grid.addColumn(Produkt::getJednostka).setHeader("Units");
            grid.getColumns().forEach(col -> col.setAutoWidth(true));
        }
    }

    public void configureForm(){
        addClassName("produkt-form");
        produktForm = new ProduktForm();
        produktForm.setWidth("250px");
    }
}
