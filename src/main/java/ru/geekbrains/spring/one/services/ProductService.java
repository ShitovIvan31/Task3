package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }


    public void addNewProduct(Product product) {
        productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        Product prod = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id: " + id));
        productRepository.delete(prod);
    }

    public final Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
