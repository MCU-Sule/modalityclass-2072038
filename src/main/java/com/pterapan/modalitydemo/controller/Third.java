package com.pterapan.modalitydemo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Third {
    public Label label1;
    public TextField txtCustom;
    private String nilai_yang_mau_dibalikin;


    public void goBackToPage2(ActionEvent actionEvent) {
        Double custom = Double.valueOf(txtCustom.getText()) / 100;
        setNilai_yang_mau_dibalikin(String.valueOf(custom));
        label1.getScene().getWindow().hide();
    }

    public String getNilai_yang_mau_dibalikin() {
        return nilai_yang_mau_dibalikin;
    }

    public void setNilai_yang_mau_dibalikin(String nilai_yang_mau_dibalikin) {
        this.nilai_yang_mau_dibalikin = nilai_yang_mau_dibalikin;
    }
}
