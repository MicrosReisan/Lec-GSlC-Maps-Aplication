package com.example.lecmcs.model;


public class Tempat {
    private String nama;
    double lang,lat;

    public Tempat(String nama, double lang, double lat) {
        this.nama = nama;
        this.lang = lang;
        this.lat = lat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}

