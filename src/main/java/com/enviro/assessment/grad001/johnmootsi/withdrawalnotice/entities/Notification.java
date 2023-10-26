package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false)
    private Long notificationId;
    @Basic
    @Column(name = "balance_before", nullable = false)
    private Double balanceBefore;
    @Basic
    @Column(name = "amount_withdrawn", nullable = false)
    private Double amountWithdrawn;
    @Basic
    @Column(name = "closing_balance", nullable = false)
    private Double closingBalance;

    // relationship properties
    @OneToOne(cascade = CascadeType.REMOVE)
    private WithdrawalNotice withdrawalNotice;

    public Notification() {
    }

    public Notification(Double balanceBefore, Double amountWithdrawn, Double closingBalance) {
        this.balanceBefore = balanceBefore;
        this.amountWithdrawn = amountWithdrawn;
        this.closingBalance = closingBalance;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Double getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(Double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public Double getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public void setAmountWithdrawn(Double amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
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
        Notification that = (Notification) o;
        return Objects.equals(notificationId, that.notificationId) && Objects.equals(balanceBefore, that.balanceBefore) && Objects.equals(amountWithdrawn, that.amountWithdrawn) && Objects.equals(closingBalance, that.closingBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, balanceBefore, amountWithdrawn, closingBalance);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", balanceBefore=" + balanceBefore +
                ", amountWithdrawn=" + amountWithdrawn +
                ", closingBalance=" + closingBalance +
                '}';
    }
}
