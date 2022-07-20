package com.pterapan.modalitydemo.model;

public class Menu {
    private String nama;
    private float harga;
    private float discount;

    public String toString() {
        return this.nama + this.harga;
    }

    public Menu(String nama, float harga, float discount) {
        this.nama = nama;
        this.harga = harga;
        this.discount = discount;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
