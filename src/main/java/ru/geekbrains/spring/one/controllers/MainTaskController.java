package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.services.ProductService;
import ru.geekbrains.spring.one.model.Product;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class MainTaskController {
    private final ProductService productService;

    @Autowired
    public MainTaskController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProductsList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/")
    public String redirectFromRoot(Model model) {
        return "redirect:/products/all";
    }

    @GetMapping("/addproduct")
    public String showNewProductForm(Model model) {
        return "create_product_form";
    }

    @GetMapping({"/{id}"})
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id, Model model) {
        try {
            productService.deleteProduct(id);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("msgError", ex.getMessage());
            return "error";
        }
        return "redirect:/products/all";
    }

    @PostMapping("/create")
    public String addNewProduct(@RequestParam Long id, @RequestParam String name, @RequestParam int price) {
        Product product = new Product(name, price);
        productService.addNewProduct(product);
        return "redirect:/products/all";
    }


}



