package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.BankingDetails;

public interface BankingDetailsService {

    BankingDetails loadBankingDetailsById(Long bankingDetailsId);
    BankingDetails createBankingDetails(Long branchCode, String bankName, String accountHolderName, Long accountNumber);
    BankingDetails createOrUpdateBankingDetails(BankingDetails bankingDetails);
    void removeBankingDetails(Long bankingDetailsId);
}
