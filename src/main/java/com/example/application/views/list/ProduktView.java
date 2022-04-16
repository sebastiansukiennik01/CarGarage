package com.example.application.views.list;

import com.example.application.Produkt;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "produkt-view", layout = MainLayout.class)
public class ProduktView extends VerticalLayout {

    public ProduktView(){
        add(new H1("Produkty"));
    }
}
