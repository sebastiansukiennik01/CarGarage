package com.example.application.views.list;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "faktura-view", layout = MainLayout.class)
public class FakturaView extends VerticalLayout {

    public FakturaView(){
        add(new H1("Faktura"));
    }
}
