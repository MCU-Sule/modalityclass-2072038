package com.pterapan.modalitydemo.controller;

import com.pterapan.modalitydemo.ModalityDemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
public class First {

    public ListView List1;
    private Stage stage;
    private ObservableList<String> slist;

    public void initialize() {
        stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        slist = FXCollections.observableArrayList();
        List1.setItems(slist);
    }

    public void AddData(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(ModalityDemo.class.getResource("second.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);

        Second sController = loader.getController();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.showAndWait();

        slist.add(sController.getNilai_yang_mau_dibalikin());
    }
}
