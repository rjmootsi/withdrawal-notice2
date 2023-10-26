package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
