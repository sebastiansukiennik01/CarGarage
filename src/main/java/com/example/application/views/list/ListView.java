package com.example.application.views.list;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Dial;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("list")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {
        add(new H1("Car garage"));
        add(new Text("Tu sobie porobimy zakładki klasy i będzie gituwa\n  Dokumentacja z wszystkimi componentami: https://vaadin.com/docs/latest/ds/components"));

        Dialog dialog = new Dialog();
        dialog.add("Co za wariat");

        Button button = new Button("Nie klikniesz", e -> dialog.open());
        add(dialog, button);
    }


}
