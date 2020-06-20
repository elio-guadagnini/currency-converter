package com.github.eliog.currencyconverter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exchange_rate", schema = "test_schema")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "btc")
    private double btc;

    @Column(name = "usd")
    private double usd;

    @Column(name = "eur")
    private double eur;

    public ExchangeRate() {
    }

    public ExchangeRate(Long id, double btc, double usd, double eur) {
        this.id = id;
        this.btc = btc;
        this.usd = usd;
        this.eur = eur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getEur() {
        return eur;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ExportingCurrencyValue{id=").append(id);
        sb.append(", btc='").append(btc);
        sb.append(", usd=").append(usd);
        sb.append(", eur=").append(eur);
        sb.append('}');
        return sb.toString();
    }
}
