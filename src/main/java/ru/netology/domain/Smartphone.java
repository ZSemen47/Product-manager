package ru.netology.domain;

import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode (callSuper = true)
public class Smartphone extends Product {
    private String performance;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String performance) {
        super(id, name, price);
        this.performance = performance;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || search.equals(performance);
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
