package com.codeid.microservices.models;

public class PemakaiKontrasepsiModel {

    private Integer Id;
    private Integer provinsi;
    private Integer kontrasepsi;
    private Integer jumlah;
    
    public PemakaiKontrasepsiModel(Integer Id, Integer provinsi, Integer kontrasepsi, Integer jumlah) {
        this.Id = Id;
        this.provinsi = provinsi;
        this.kontrasepsi = kontrasepsi;
        this.jumlah = jumlah;
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getProvinsi() {
        return this.provinsi;
    }

    public void setProvinsi(Integer provinsi) {
        this.provinsi = provinsi;
    }

    public Integer getKontrasepsi() {
        return this.kontrasepsi;
    }

    public void setKontrasepsi(Integer kontrasepsi) {
        this.kontrasepsi = kontrasepsi;
    }

    public Integer getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}