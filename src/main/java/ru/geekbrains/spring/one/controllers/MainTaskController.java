package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.services.ProductService;
import ru.geekbrains.spring.one.model.Product;

import java.util.List;


@Controller
@RequestMapping("/")
public class MainTaskController {
    private final ProductService productService;

    @Autowired
    public MainTaskController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String getAllProductsList(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/")
    public String redirectFromRoot(Model model){
        return "redirect:/index";
    }

    @GetMapping("/addproduct")
    public String showNewProductForm(Product product){
        return "add-product";
    }

    @PostMapping("/addproduct")
    public String addNewProduct(Product product){
        productService.addNewProduct(product);
        return "redirect:/index";
    }


}



