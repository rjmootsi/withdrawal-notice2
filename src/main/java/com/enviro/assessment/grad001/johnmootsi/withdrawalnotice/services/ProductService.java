package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;

import java.util.List;

public interface ProductService {

    Product loadProductById(Long productId);
    Product createProduct(String productName, String productType, Double currentBalance, Long investorId);
    Product createOrUpdateProduct(Product product);
    List<Product> findProductsByProductName(String keyword);
    List<Product> findProductsByProductType(String keyword);
    void assignInvestorToProduct(Long productId, Long investorId);
    List<Product> fetchAll();
    List<Product> fetchAllInvestorProducts(Long investorId);
    void removeProduct(Long productId);
}
