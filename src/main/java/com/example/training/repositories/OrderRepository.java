package com.example.training.repositories;

import com.example.training.Entity.Orders;
import com.example.training.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {

}
