package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "investments")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_id", nullable = false)
    private Long investmentId;
    @Basic
    @Column(name = "investment_amount", nullable = false)
    private Double investmentAmount;

    // relationship properties

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", referencedColumnName = "investor_id", nullable = false)
    private Investor investor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    public Investment() {
    }

    public Investment(Double investmentAmount, Investor investor, Product product) {
        this.investmentAmount = investmentAmount;
        this.investor = investor;
        this.product = product;
    }

    public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investment that = (Investment) o;
        return Objects.equals(investmentId, that.investmentId) && Objects.equals(investmentAmount, that.investmentAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(investmentId, investmentAmount);
    }

    @Override
    public String toString() {
        return "Investment{" +
                "investmentId=" + investmentId +
                ", investmentAmount=" + investmentAmount +
                '}';
    }
}
