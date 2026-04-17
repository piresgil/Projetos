module main.application {
  // requires javafx.controls;
  // requires javafx.fxml;
    requires com.opencsv;
    requires org.json;


    opens main.application to javafx.fxml;
    exports main.application;
    exports main.application.phishing;
    opens main.application.phishing to javafx.fxml;
    exports main.application.anti;
    opens main.application.anti to javafx.fxml;

    //requires org.apache.commons.lang3;
    //requires org.apache.commons.text;
    //requires commons.collections;

    // Módulos automáticos para bibliotecas não modularizadas
    //requires commons.beanutils; // Nome automático do módulo
    //requires commons.logging;
    requires java.net.http;
    //requires com.google.gson;    // Nome automático do módulo

    // Abrir o pacote 'controller' para o módulo 'javafx.fxml'
    opens main.application.controller to javafx.fxml;
    exports main.application.controller;
    exports main.application.utils;
    opens main.application.utils to javafx.fxml; // Exporta o pacote do controller
}