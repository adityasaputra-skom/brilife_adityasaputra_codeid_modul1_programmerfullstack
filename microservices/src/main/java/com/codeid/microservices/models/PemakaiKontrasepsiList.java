package com.codeid.microservices.models;

public class PemakaiKontrasepsiList {

    private Integer provinsi;
    private Integer Kontrasepsi;
    private Integer jumlah;

    public PemakaiKontrasepsiList(Integer provinsi, Integer Kontrasepsi, Integer jumlah) {
        this.provinsi = provinsi;
        this.Kontrasepsi = Kontrasepsi;
        this.jumlah = jumlah;
    }

    public Integer getProvinsi() {
        return this.provinsi;
    }

    public void setProvinsi(Integer provinsi) {
        this.provinsi = provinsi;
    }

    public Integer getKontrasepsi() {
        return this.Kontrasepsi;
    }

    public void setKontrasepsi(Integer Kontrasepsi) {
        this.Kontrasepsi = Kontrasepsi;
    }

    public Integer getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}