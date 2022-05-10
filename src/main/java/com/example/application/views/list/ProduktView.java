package com.example.application.views.list;

import com.example.application.Klient;
import com.example.application.Produkt;
import com.example.application.Produkty;
import com.example.application.SqlDbProdukt;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.validation.constraints.Null;
import java.sql.SQLException;
import java.util.stream.Stream;

@Route(value = "produkt-view", layout = MainLayout.class)
public class ProduktView extends VerticalLayout {
    /**
     * Class inherits Vertical Layout. Object of this class is a whole view with grid (list) of products
     * and a side form, where we can perform operations on list of products (such as add, remove, etc.).
     */

    static Grid<Produkt> grid = new Grid<>(Produkt.class, false);
    static Produkty products;
    ProduktForm produktForm;

    /**
     * Returns grid with products
     * @return grid
     */
    public Grid<Produkt> getGrid() {
        return grid;
    }

    /**
     * Sets a grid with products
     * @param grid
     */
    public void setGrid(Grid<Produkt> grid) {
        ProduktView.grid = grid;
    }

    /**
     * Un-parametrized constructor, sets size of view to full, and calls methods configureGrid()
     * and configureForm() which are responsible for configuring both grid, and form layouts.
     * Adds configured content to the view.
     */
    public ProduktView(){
        addClassName("produkt-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(new H1("Produkty"));
        add(getContent());
    }

    /**
     * Responsible for alligning the grid and form side by side.
     * Returns content (of type HorizontalLayout) which can be added to the view.
     * @return content
     */
    private HorizontalLayout getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, produktForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, produktForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    /**
     * Responsible for correctly configuring the grid. If the grid is empty, then adds all the needed
     * columns to it, automatically sets columns width, and selection mode to multiple (allows for multiple selection).
     * Populates grid with values extracted from DataBase via SqlDbProdukt class and method getProducts().
     * If connecting/querying database failes, then raises error and shows notification with it.
     */
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
        try{
            products = SqlDbProdukt.getProducts();
            grid.setItems(products.getProduktList());
        }catch (SQLException e){
            Notification.show("Failed to load Products from database! Please restart application.");
        }
    }

    /**
     * Responsible for configuring the side form with functionalities. Initiates and object of class
     * ProduktForm() and sets width to 250 px.
     */
    public void configureForm(){
        addClassName("produkt-form");
        produktForm = new ProduktForm();
        produktForm.setWidth("250px");
    }
}
