package com.example.application.views.list;

import com.example.application.Klient;
import com.example.application.Produkt;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "produkt-view", layout = MainLayout.class)
public class ProduktView extends VerticalLayout {
    Grid<Produkt> grid = new Grid<>(Produkt.class);
    ProduktForm produktForm;

    public ProduktView(){
        addClassName("produkt-view");
        setSizeFull();
        configureGrid();
        configureForm();
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
        grid.addClassNames("produkt-grid");
        grid.setSizeFull();
        grid.setColumns("nrProduktu", "nazwa", "ilosc", "cena", "jednostka");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }


    public void configureForm(){
        addClassName("produkt-form");
        produktForm = new ProduktForm();
        produktForm.setWidth("250px");
    }
}
