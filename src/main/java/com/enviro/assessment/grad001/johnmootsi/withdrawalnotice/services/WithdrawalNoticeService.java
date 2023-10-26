package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;

import java.time.LocalDate;
import java.util.List;

public interface WithdrawalNoticeService {

    WithdrawalNotice loadWithdrawalsById(Long withdrawalId);
    List<WithdrawalNotice> fetchAllInvestorWithdrawals(Long investorId);
    WithdrawalNotice createWithdrawal(Double withdrawalAmount, LocalDate withdrawalDate, Long bankingDetailsId, Long productId, Long investorId);
    WithdrawalNotice createOrUpdateWithdrawal(WithdrawalNotice withdrawal);
    List<WithdrawalNotice> fetchWithdrawalsByDate(LocalDate date);
    void removeWithdrawal(Long withdrawalId);
}
