package com.digitalbooking.repository;

import com.digitalbooking.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.city.name = :name")
    List<Product> findByCity(String name);

    @Query("select p from Product p where p.category.title = :title")
    List<Product> findByCategory(String title);
}
