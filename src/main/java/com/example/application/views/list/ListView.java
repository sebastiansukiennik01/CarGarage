package com.example.application.views.list;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("list")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {
        add(new H1("Hello world"));
        add(new H2("Testowy nagłówek"));
    }

}
