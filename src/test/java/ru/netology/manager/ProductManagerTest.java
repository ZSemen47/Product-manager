package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    ProductManager manager;
    Product first = new Book(1, "Old legends", 1000, "Great", 4221, 1985);
    Product second = new Book(2, "New legends", 1000, "Nongreat", 185, 2020);
    Product third = new Smartphone(3, "Motorolla", 500, "good");
    Product fourth = new Smartphone(4, "Nokia", 600, "very good");

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }
    @Test
    public void searchBookTWithAuthor(){
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Great");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchBookTWithName(){
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("New legends");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchSmartphoneWithName(){
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Motorolla");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchSmartphoneWithPerfomance(){
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("very good");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchProductWhichNotExists(){
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Last air bender");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}