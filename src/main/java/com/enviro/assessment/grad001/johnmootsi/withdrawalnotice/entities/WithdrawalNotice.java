package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "withdrawal_notices")
public class WithdrawalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdrawal_notice_id", nullable = false)
    private Long withdrawalNoticeId;
    @Basic
    @Column(name = "withdrawal_amount", nullable = false)
    private Double withdrawalAmount;
    @Basic
    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Relationship properties
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "banking_details_id", referencedColumnName = "banking_details_id", nullable = false)
    private BankingDetails bankingDetails;

    // many-to-one relationship, as multiple withdrawals can be associated with a single product.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product; // The product from which the withdrawal is being made.

    // many-to-one relationship, as multiple withdrawals can be associated with a single investor.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", referencedColumnName = "investor_id", nullable = false)
    private Investor investor; // The investor who is making the withdrawal.

    public WithdrawalNotice() {
    }

    public WithdrawalNotice(Double withdrawalAmount, LocalDate date, BankingDetails bankingDetails, Product product) {
        this.withdrawalAmount = withdrawalAmount;
        this.date = date;
        this.bankingDetails = bankingDetails;
        this.product = product;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Long getWithdrawalNoticeId() {
        return withdrawalNoticeId;
    }

    public void setWithdrawalNoticeId(Long withdrawalNoticeId) {
        this.withdrawalNoticeId = withdrawalNoticeId;
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BankingDetails getBankingDetails() {
        return bankingDetails;
    }

    public void setBankingDetails(BankingDetails bankingDetails) {
        this.bankingDetails = bankingDetails;
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
        WithdrawalNotice that = (WithdrawalNotice) o;
        return Objects.equals(withdrawalNoticeId, that.withdrawalNoticeId) && Objects.equals(withdrawalAmount, that.withdrawalAmount) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(withdrawalNoticeId, withdrawalAmount, date);
    }

    @Override
    public String toString() {
        return "WithdrawalNotice{" +
                "withdrawalNoticeId=" + withdrawalNoticeId +
                ", withdrawalAmount=" + withdrawalAmount +
                ", date=" + date +
                '}';
    }
}
