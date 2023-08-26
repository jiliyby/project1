package com.example.training.repositories;

import com.example.training.Entity.Product;
import com.example.training.Entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
