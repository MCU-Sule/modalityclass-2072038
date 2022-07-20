package com.pterapan.modalitydemo.controller;

import com.pterapan.modalitydemo.ModalityDemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Second {
    public Label label1;
    public TextField textfield1;
    public TextField txtNama;
    public TextField txtHarga;
    public ComboBox cmb1;
    public Button btn1;
    private String nilai_yang_mau_dibalikin;

    public void setLabel(String s) { label1.setText(s); }

    public void initialize() {
        ObservableList<Double> discountList = FXCollections.observableArrayList(0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9);
        cmb1.setItems(discountList);
        cmb1.getSelectionModel().select(0);
    }

    public void goToPage3(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(label1.getScene().getWindow());

        FXMLLoader loader;
        loader = new FXMLLoader(ModalityDemo.class.getResource("third.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);
        Third sController = loader.getController();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.showAndWait();

        btn1.setText(sController.getNilai_yang_mau_dibalikin());
    }
    public void goBackToPage1(ActionEvent actionEvent) {
        Double disc = (Double) cmb1.getSelectionModel().getSelectedItem();
        String discCustom = btn1.getText();

        if (disc > 0) {
                Double discount = disc * 100;
                String harga = txtHarga.getText();
                Double count = Double.valueOf(harga) - (disc * Double.valueOf(harga));
                setNilai_yang_mau_dibalikin(txtNama.getText() + " " + count + " (original price : " + txtHarga.getText() + ") Discount : " + discount + "%");
        }
        else if (disc < 0 && discCustom != null) {
            Double discount = Double.valueOf(discCustom) * 100;
            String harga = txtHarga.getText();
            Double custom = Double.valueOf(harga) - (Double.valueOf(discCustom) * Double.valueOf(harga));
            setNilai_yang_mau_dibalikin(txtNama.getText() + " " + custom + " (original price : " + txtHarga.getText() + ") Discount : " + discount + "%");
        }
        else {
            setNilai_yang_mau_dibalikin(txtNama.getText() + " " + Double.valueOf(txtHarga.getText()));
        }
        label1.getScene().getWindow().hide();
    }

    public String getNilai_yang_mau_dibalikin() {
        return nilai_yang_mau_dibalikin;
    }

    public void setNilai_yang_mau_dibalikin(String nilai_yang_mau_dibalikin) {
        this.nilai_yang_mau_dibalikin = nilai_yang_mau_dibalikin;
    }
}
