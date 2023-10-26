package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Basic
    @Column(name = "product_type", nullable = false)
    private String productType;
    @Basic
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Basic
    @Column(name = "product_balance", nullable = false)
    private Double productBalance;

    // relationship properties

    // many-to-one relationship, as multiple products can be associated with a single investor.
    @ManyToOne(fetch = FetchType.LAZY) // doesn't need to view the investor when fetching a product
    @JoinColumn(name = "investor_id", referencedColumnName = "investor_id", nullable = false) // to add the foreign key
    private Investor investor; // The investor who has invested in this product.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investment_id", referencedColumnName = "investment_id", nullable = false)
    private Investment investment;


    // one-to-many relationship, as a product can have multiple withdrawals.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "withdrawal_notice_id", referencedColumnName = "withdrawal_notice_id", nullable = false) // adds both primary keys into the new table that manages withdrawals and products
    private WithdrawalNotice withdrawalNotice;

    public Product() {
    }

    public Product(String productType, String productName, Double productBalance, Investor investor) {
        this.productType = productType;
        this.productName = productName;
        this.productBalance = productBalance;
        this.investor = investor;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductBalance() {
        return productBalance;
    }

    public void setProductBalance(Double productBalance) {
        this.productBalance = productBalance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public WithdrawalNotice getWithdrawalNotice() {
        return withdrawalNotice;
    }

    public void setWithdrawalNotice(WithdrawalNotice withdrawalNotice) {
        this.withdrawalNotice = withdrawalNotice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productType, product.productType) && Objects.equals(productName, product.productName) && Objects.equals(productBalance, product.productBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productType, productName, productBalance);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", productBalance=" + productBalance +
                '}';
    }
}



