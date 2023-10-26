package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "banking_details")
public class BankingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banking_details_id", nullable = false)
    private Long bankingDetailsId;
    @Basic
    @Column(name = "bank_name", nullable = false, length = 64)
    private String bankName;
    @Basic
    @Column(name = "branch_code", nullable = false)
    private Long branchCode;
    @Basic
    @Column(name = "account_holder", nullable = false, length = 45)
    private String accountHolder;
    @Basic
    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

    // Relationship properties
    @OneToOne(mappedBy = "bankingDetails", fetch = FetchType.LAZY)
    private WithdrawalNotice withdrawalNotice;

    public BankingDetails() {
    }

    public BankingDetails(String bankName, Long branchCode, String accountHolder, Long accountNumber) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public Long getBankingDetailsId() {
        return bankingDetailsId;
    }

    public void setBankingDetailsId(Long bankingDetailsId) {
        this.bankingDetailsId = bankingDetailsId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Long branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
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
        BankingDetails that = (BankingDetails) o;
        return Objects.equals(bankingDetailsId, that.bankingDetailsId) && Objects.equals(bankName, that.bankName) && Objects.equals(branchCode, that.branchCode) && Objects.equals(accountHolder, that.accountHolder) && Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankingDetailsId, bankName, branchCode, accountHolder, accountNumber);
    }

    @Override
    public String toString() {
        return "BankingDetails{" +
                "bankingDetailsId=" + bankingDetailsId +
                ", bankName='" + bankName + '\'' +
                ", branchCode=" + branchCode +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
