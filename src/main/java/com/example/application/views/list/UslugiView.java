package com.example.application.views.list;

import com.example.application.Uslugi;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "uslugi-view", layout = MainLayout.class)
public class UslugiView extends VerticalLayout {

    public UslugiView(){
        add(new H1("Usługi"));
    }

}
