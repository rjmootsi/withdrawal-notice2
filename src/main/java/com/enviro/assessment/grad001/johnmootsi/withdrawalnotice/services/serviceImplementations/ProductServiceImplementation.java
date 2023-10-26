package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.InvestorDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.ProductDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.ProductService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class ProductServiceImplementation implements ProductService {

    // Dependencies needed
    private ProductDao productDao;
    private InvestorDao investorDao;

    public ProductServiceImplementation(ProductDao productDao, InvestorDao investorDao) {
        this.productDao = productDao;
        this.investorDao = investorDao;
    }


    @Override
    public Product loadProductById(Long productId) {
        return productDao.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product with id: "+productId+" Not found"));
    }

    @Override
    public Product createProduct(String productName, String productType, Double currentBalance, Long investorId) {
        Investor investor = investorDao.findById(investorId).orElseThrow(() -> new EntityNotFoundException("Investor with id: "+investorId+" Not found"));
        return productDao.save(new Product(productName, productType, currentBalance, investor));
    }

    @Override
    public Product createOrUpdateProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findProductsByProductName(String keyword) {
        return productDao.findProductsByProductNameContains(keyword);
    }

    @Override
    public List<Product> findProductsByProductType(String keyword) {
        return productDao.findProductsByProductTypeContains(keyword);
    }

    @Override
    public void assignInvestorToProduct(Long productId, Long investorId) {

    }

    @Override
    public List<Product> fetchAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> fetchAllInvestorProducts(Long investorId) {
        return productDao.getProductsByInvestorId(investorId);
    }

    @Override
    public void removeProduct(Long productId) {
        productDao.deleteById(productId);
    }
}
