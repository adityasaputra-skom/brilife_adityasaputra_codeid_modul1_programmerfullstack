package com.codeid.microservices.entities;

import javax.persistence.*;

@Table(name = "list_pemakai_kontrasepsi")
@Entity
@SuppressWarnings("serial")
public class PemakaiKontrasepsi extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Provinsi provinsi;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Kontrasepsi kontrasepsi;

    @Column(name = "jumlah_pemakai")
    private Integer jumlah;

    public PemakaiKontrasepsi(){}

    public PemakaiKontrasepsi(Provinsi provinsi, Kontrasepsi kontrasepsi, Integer jumlah) {
        this.provinsi = provinsi;
        this.kontrasepsi = kontrasepsi;
        this.jumlah = jumlah;
    }

    public Provinsi getProvinsi() {
        return this.provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public Kontrasepsi getKontrasepsi() {
        return this.kontrasepsi;
    }

    public void setKontrasepsi(Kontrasepsi kontrasepsi) {
        this.kontrasepsi = kontrasepsi;
    }

    public Integer getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}