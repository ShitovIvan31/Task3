package ru.geekbrains.spring.one.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Apple", 80),
                new Product(2L, "Banana", 90),
                new Product(3L, "Pineapple", 100),
                new Product(4L, "Carrot", 90)
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        products.add(product);
    }

//    public void findById(Long id) {
//        for (Product p : products) {
//            if (p.getId().equals(id)) {
//                return;
//            }
//        }
//    }

}
