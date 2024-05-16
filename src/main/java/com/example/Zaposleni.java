package com.example;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zaposleni")
public class Zaposleni implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ime;
    private int godine;
    private String adresa;
    private Double prihod;

    public Zaposleni(){}

    public Zaposleni(int id, String ime, int godine, String adresa, double prihod) {
        this.id = id;
        this.ime = ime;
        this.godine = godine;
        this.adresa = adresa;
        this.prihod = prihod;
    }

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
