package com.github.eliog.currencyconverter.training;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// if the answer is not a JSON, it is ignored (as well as Unknown sources, I guess)
@JsonIgnoreProperties(ignoreUnknown = true)
// @JsonProperty - to specify the exact key of the JSON document
public class Quote {

    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
