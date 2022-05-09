package com.example.application.views.list;

import com.example.application.Klient;
import com.example.application.Produkt;
import com.example.application.Samochod;
import com.example.application.Usluga;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route(value = "faktura-view", layout = MainLayout.class)
public class FakturaView extends VerticalLayout {

    ComboBox<Klient> clientCmb = new ComboBox<>("Client");
    ComboBox<Samochod> carCmb = new ComboBox("Car");
    ComboBox<Produkt> productCmb = new ComboBox("Products");
    DatePicker datePicker = new DatePicker("Date");
    ComboBox<Usluga> serviceCmb = new ComboBox("Service");  // tu trzeba coś innego tak żeby można było wybrać kilka usług
    TextArea summaryTxtArea = new TextArea();
    Button summaryBtn = new Button("Summary", this::summary);
    Button clearBtn = new Button("Clear", this::clear);

    public FakturaView(){
        addClassName("klient-view");
        setSizeFull();
        configureForm();
        add(new H1("Faktury"));
        add(getContent());
    }

    private VerticalLayout getContent(){
        VerticalLayout content = new VerticalLayout(clientCmb, carCmb, productCmb, datePicker, serviceCmb);
        content.add(createButtonsLayout());
        content.add(summaryTxtArea);

        return content;
    }

    private void configureForm(){
        clientCmb.setItems(KlientView.klienci.getKlientList());

        //clientCmb.addValueChangeListener(valueChangeEvent -> {
          //  carCmb.setItems(clientCmb.getValue().getCars().getSamochodList());
       // });

        productCmb.setItems(ProduktView.products.getProduktList());
        serviceCmb.setItems(UslugiView.uslugi.getUslugiList());

        clientCmb.setItemLabelGenerator(k -> k.getImie() + " " + k.getNazwisko() + ", " + k.getNrTelefonu());
        carCmb.setItemLabelGenerator(s -> s.getMarka() + " " + s.getModel() + ", Nr rej: " + s.getNrRejstracyjny());
        productCmb.setItemLabelGenerator(p -> p.getNazwa() + " " + p.getCena() + "zł / " + p.getJednostka());
        serviceCmb.setItemLabelGenerator(u -> u.getNazwa() + ": " + u.getKoszt());

        clientCmb.setWidth("500px");
        carCmb.setWidth("500px");
        productCmb.setWidth("500px");
        serviceCmb.setWidth("500px");

        summaryTxtArea.setWidthFull();
        summaryTxtArea.setHeight("200px");
        summaryTxtArea.setLabel("Invoice summary");
        summaryTxtArea.setValue("Szczegóły faktury");
    }

    private HorizontalLayout createButtonsLayout(){
        summaryBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        clearBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);

        summaryBtn.addClickShortcut(Key.ENTER);
        clearBtn.addClickShortcut(Key.ESCAPE);

        summaryBtn.setWidth("500px");
        clearBtn.setWidth("500px");

        HorizontalLayout horizontalLayout = new HorizontalLayout(summaryBtn, clearBtn);
        horizontalLayout.setWidth("100%");
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        return horizontalLayout;
    }

    // ta cała funkcja jest do naprawienia, bo nie wypisuje wyniku do summaryTextArea
    private void summary(ClickEvent<Button> buttonClickEvent) {
        try{
            Klient k = this.clientCmb.getValue();
            Samochod s = this.carCmb.getValue();
            String d = this.datePicker.getValue().toString();
            Produkt p = this.productCmb.getValue();
            Usluga u = this.serviceCmb.getValue();

            String result = k.getImie() + " " + k.getNazwisko() + ", " + k.getNrTelefonu() + "\n" +
                    s.getMarka() + " " + s.getModel() + ", Nr rej: " + s.getNrRejstracyjny() + "\n" +
                    p.getNazwa() + " " + p.getCena() + "zł / " + p.getJednostka() + "\n" +
                    d + "\n" +
                    u.getNazwa() + " " + u.getKoszt();
            this.summaryTxtArea.setValue(result);
            Notification.show("Invoice generated succesfully!");
        }catch (NullPointerException e){
            Notification.show("Not enough data to create an invoice. Please select all the fields to generate an invoice");
        }catch (Exception e){
            Notification.show("An error occurred. Please try again");
            Notification.show(e.getMessage());
        }

    }

    private void clear(ClickEvent<Button> buttonClickEvent){
        this.clientCmb.clear();
        this.carCmb.clear();
        this.productCmb.clear();
        this.datePicker.clear();
        this.serviceCmb.clear();
        this.summaryTxtArea.clear();
        Notification.show("Form cleared succesfully!");
    }
}
