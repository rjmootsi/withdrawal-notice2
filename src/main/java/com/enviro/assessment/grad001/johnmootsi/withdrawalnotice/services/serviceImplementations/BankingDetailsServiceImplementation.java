package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.BankingDetailsDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.BankingDetails;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.BankingDetailsService;
import jakarta.persistence.EntityNotFoundException;

public class BankingDetailsServiceImplementation implements BankingDetailsService {
    private BankingDetailsDao bankingDetailsDao;

    public BankingDetailsServiceImplementation(BankingDetailsDao bankingDetailsDao) {
        this.bankingDetailsDao = bankingDetailsDao;
    }

    @Override
    public BankingDetails loadBankingDetailsById(Long bankingDetailsId) {
        return bankingDetailsDao.findById(bankingDetailsId).orElseThrow(() -> new EntityNotFoundException("BankingDetails id: "+bankingDetailsId+" not found"));
    }

    @Override
    public BankingDetails createBankingDetails(Long branchCode, String bankName, String accountHolder, Long accountNumber) {
        return bankingDetailsDao.save(new BankingDetails(bankName, branchCode, accountHolder, accountNumber));
    }

    @Override
    public BankingDetails createOrUpdateBankingDetails(BankingDetails bankingDetails) {
        return bankingDetailsDao.save(bankingDetails);
    }


    @Override
    public void removeBankingDetails(Long bankingDetailsId) {
        bankingDetailsDao.deleteById(bankingDetailsId);
    }
}
