module com.example.proyectoud1iagomartin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens proyectoud1iagomartin.cocktails to javafx.fxml;
    exports proyectoud1iagomartin.cocktails;

    exports proyectoud1iagomartin.cocktails.model;
    opens proyectoud1iagomartin.cocktails.model;

    exports proyectoud1iagomartin.cocktails.controller;
    opens proyectoud1iagomartin.cocktails.controller to javafx.fxml;
    exports proyectoud1iagomartin.cocktails.tools;
    opens proyectoud1iagomartin.cocktails.tools to javafx.fxml;
}