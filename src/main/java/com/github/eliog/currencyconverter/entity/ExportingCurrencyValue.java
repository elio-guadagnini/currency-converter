package com.github.eliog.currencyconverter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exchange_rate", schema = "test_schema")
//@Entity
//@Table(name = "cities")
public class ExportingCurrencyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_currency")
    private String first_currency;

    @Column(name = "second_currency")
    private String second_currency;

    @Column(name = "exchange_value")
    private double exchange_value;

    public ExportingCurrencyValue() {
    }

    public ExportingCurrencyValue(Long id, String first_currency, String second_currency, double exchange_value) {
        this.id = id;
        this.first_currency = first_currency;
        this.second_currency = second_currency;
        this.exchange_value = exchange_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_currency() {
        return first_currency;
    }

    public void setFirst_currency(String first_currency) {
        this.first_currency = first_currency;
    }

    public String getSecond_currency() {
        return second_currency;
    }

    public void setSecond_currency(String second_currency) {
        this.second_currency = second_currency;
    }

    public double getExchange_value() {
        return exchange_value;
    }

    public void setExchange_value(double exchange_value) {
        this.exchange_value = exchange_value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CurrencyValue{");
        sb.append("id=").append(id);
        sb.append(", first_currency='").append(first_currency);
        sb.append(", second_currency=").append(second_currency);
        sb.append(", exchange_value=").append(exchange_value);
        sb.append('}');
        return sb.toString();
    }
}
