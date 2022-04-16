package com.example.application.views.list;

import com.example.application.Produkt;
import com.example.application.Usluga;
import com.example.application.Uslugi;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;


@Route(value = "uslugi-view", layout = MainLayout.class)
public class UslugiView extends VerticalLayout {
    Grid<Usluga> grid = new Grid<>(Usluga.class);
    FormLayout uslugaForm = new FormLayout();


    public UslugiView(){
        addClassName("usluga-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(getComponents());
    }

    private HorizontalLayout getComponents(){
        HorizontalLayout content = new HorizontalLayout(grid, uslugaForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, uslugaForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid(){
        addClassName("usluga-grid");
        grid.setSizeFull();
        grid.setColumns("nazwa", "koszt");
        grid.setHeightFull();
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    public void configureForm(){
        addClassName("usluga-form");
        uslugaForm = new UslugiForm();
        uslugaForm.setWidth("250px");
    }

}
