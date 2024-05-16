package com.example;

import java.io.Serializable;

public class ZaposleniApp implements Serializable {
    private int id;
    private String ime;
    private int godine;
    private String adresa;
    private double prihod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getPrihod() {
        return prihod;
    }

    public void setPrihod(double prihod) {
        this.prihod = prihod;
    }
}
