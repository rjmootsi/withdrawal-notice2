package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

// The Investor entity will represent an investor in your system.

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investor_id", nullable = false)
    private Long investorId;
    @Basic
    @Column(name = "inverstor_name", nullable = false, length = 45)
    private String investorName;
    @Basic
    @Column(name = "investor_lastname", nullable = false, length = 45)
    private String investorLastname;
    @Basic
    @Column(name = "investor_age", nullable = false)
    private Double investorAge;
    @Basic
    @Column(name = "investor_contact", nullable = false)
    private String investorContact;
    @Basic
    @Column(name = "investor_address", nullable = false)
    private String investorAddress;

    // Relationship properties

    // one to many as an investor can have multiple products.
    @OneToMany(mappedBy = "investor", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>(); // A list of Product entities that the investor has invested in.

    // one to many as an investor can have multiple investments.
    @OneToMany(mappedBy = "investor", fetch = FetchType.LAZY)
    private Set<Investment> investments = new HashSet<>();

    // one to many as an investor can make multiple withdrawals.
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "investor_withdrawals",
            joinColumns = {@JoinColumn(name = "investor_id")},
            inverseJoinColumns = {@JoinColumn(name = "withdrawal_notice_id")}) // adds both primary keys into the new association table that manages withdrawalNotices and investors
    private Set<WithdrawalNotice> withdrawalNotices = new HashSet<>();


    public Investor() {
    }

    public Investor(String investorName, String investorLastname, Double investorAge, String investorContact, String investorAddress) {
        this.investorName = investorName;
        this.investorLastname = investorLastname;
        this.investorAge = investorAge;
        this.investorContact = investorContact;
        this.investorAddress = investorAddress;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorLastname() {
        return investorLastname;
    }

    public void setInvestorLastname(String investorLastname) {
        this.investorLastname = investorLastname;
    }

    public Double getInvestorAge() {
        return investorAge;
    }

    public void setInvestorAge(Double investorAge) {
        this.investorAge = investorAge;
    }

    public String getInvestorContact() {
        return investorContact;
    }

    public void setInvestorContact(String investorContact) {
        this.investorContact = investorContact;
    }

    public String getInvestorAddress() {
        return investorAddress;
    }

    public void setInvestorAddress(String investorAddress) {
        this.investorAddress = investorAddress;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    public Set<WithdrawalNotice> getWithdrawalNotices() {
        return withdrawalNotices;
    }

    public void setWithdrawalNotices(Set<WithdrawalNotice> withdrawalNotices) {
        this.withdrawalNotices = withdrawalNotices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investor investor = (Investor) o;
        return Objects.equals(investorId, investor.investorId) && Objects.equals(investorName, investor.investorName) && Objects.equals(investorLastname, investor.investorLastname) && Objects.equals(investorAge, investor.investorAge) && Objects.equals(investorContact, investor.investorContact) && Objects.equals(investorAddress, investor.investorAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(investorId, investorName, investorLastname, investorAge, investorContact, investorAddress);
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", investorLastname='" + investorLastname + '\'' +
                ", investorAge=" + investorAge +
                ", investorContact='" + investorContact + '\'' +
                ", investorAddress='" + investorAddress + '\'' +
                '}';
    }
}
