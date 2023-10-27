package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findProductsByProductNameContains(String keyword);

    List<Product> findProductsByProductTypeContains(String Keyword); // To find products by their type


    // this method is not available in the JpaRepository hence added here
//    @Query(value = "SELECT * FROM products as p WHERE p.investor_id = :investorId", nativeQuery = true)
    @Query(value = "select * from products as p where p.product_id in (select i.investor_id from investors as i where i.investor_id =: investorId)", nativeQuery = true)
    List<Product> getProductsByInvestorId(@Param("investorId") Long investorId);
}
