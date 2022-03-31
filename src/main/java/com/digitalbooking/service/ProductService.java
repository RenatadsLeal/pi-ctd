package com.digitalbooking.service;

import com.digitalbooking.model.Product;
import com.digitalbooking.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {

        return repository.save(product);
    }

    public Product editById(Product editedProduct, Integer id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(editedProduct.getName());
                    product.setDescription(editedProduct.getDescription());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    editedProduct.setId(id);
                    return repository.save(editedProduct);
                });
    }

    public Product getById(Integer id) {
        return repository.getById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<Product> findByCity(String name) {
        return repository.findByCity(name);
    }

    public List<Product> findByCategory(String title) {
        return repository.findByCategory(title);
    }
}
