package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repositories.ProductRepository;

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
        return productRepository.findAll();
    }




    public void addNewProduct(Product product) {
        productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        Optional<Product> prod = productRepository.findById(id);
        productRepository.delete(prod);
    }

    public final Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
