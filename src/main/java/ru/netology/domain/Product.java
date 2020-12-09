package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.ProductRepository;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        return getName().equalsIgnoreCase(search);
    }
}