package ru.netology.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Smartphone extends Product {
    private String performance;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String performance) {
        super(id, name, price);
        this.performance = performance;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
