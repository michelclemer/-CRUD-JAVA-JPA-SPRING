package com.cursoJava.demo.service;


import com.cursoJava.demo.entity.Product;
import com.cursoJava.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutcService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product prod){
        return repository.save(prod);
    }

    public List<Product> saveProducts(List<Product> prods){
        return repository.saveAll(prods);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByIdName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Produto removido!! " +id;
    }

    public Product upadteProduct(Product product){
        Product exinstingProduct = repository.findById(product.getId()).orElse(null);
        if(exinstingProduct!=null){
            exinstingProduct.setName(product.getName());
            exinstingProduct.setQuantity(product.getQuantity());
            exinstingProduct.setPrice(product.getPrice());
            return repository.save(exinstingProduct);
        }
        return null;

    }



}
