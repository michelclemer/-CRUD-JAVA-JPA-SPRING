package com.cursoJava.demo.controller;


import com.cursoJava.demo.entity.Product;
import com.cursoJava.demo.service.ProdutcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class ProductController {
    @Autowired
    private ProdutcService service;
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @GetMapping("/product/{id}")
    public Product findProductById( @PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public  Product findProductByName( @PathVariable String name){
        return service.getProductByIdName(name);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct( @PathVariable  int id){
        return service.deleteProduct(id);
    }

    @PutMapping("/update")
    public Product updateProduct( @PathVariable Product product){
        return service.upadteProduct(product);
    }

}
