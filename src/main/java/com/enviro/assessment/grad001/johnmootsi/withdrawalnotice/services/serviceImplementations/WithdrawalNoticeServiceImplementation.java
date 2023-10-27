package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.WithdrawalNoticeDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.BankingDetails;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.BankingDetailsService;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.InvestorService;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.ProductService;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.WithdrawalNoticeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WithdrawalNoticeServiceImplementation implements WithdrawalNoticeService {

    private WithdrawalNoticeDao withdrawalNoticeDao;
    private ProductService productService;
    private InvestorService investorService;
    private BankingDetailsService bankingDetailsService;

    public WithdrawalNoticeServiceImplementation(WithdrawalNoticeDao withdrawalNoticeDao, ProductService productService, InvestorService investorService, BankingDetailsService bankingDetailsService) {
        this.withdrawalNoticeDao = withdrawalNoticeDao;
        this.productService = productService;
        this.investorService = investorService;
        this.bankingDetailsService = bankingDetailsService;
    }


    @Override
    public WithdrawalNotice loadWithdrawalsById(Long withdrawalId) {
        return withdrawalNoticeDao.findById(withdrawalId).orElseThrow(() -> new EntityNotFoundException("Withdrawal with id: "+withdrawalId+" not found"));
    }

    @Override
    public List<WithdrawalNotice> fetchAllInvestorWithdrawals(Long investorId) {
//        return withdrawalNoticeDao.getWithdrawalsByInvestorId(investorId);
        return null;
    }

    @Override
    public WithdrawalNotice createWithdrawal(Double withdrawalAmount, LocalDate withdrawalDate, Long bankingDetailsId, Long productId, Long investorId) {
        Investor investor = investorService.loadInvestorById(investorId);
        Product product = productService.loadProductById(productId);
        BankingDetails bankingDetails = bankingDetailsService.loadBankingDetailsById(bankingDetailsId);
        LocalDate date = LocalDate.now();
        WithdrawalNotice withdrawal = new WithdrawalNotice(withdrawalAmount, date, bankingDetails, product);
        // validate before saving
        validateWithdrawal(withdrawal);
        return withdrawal;
    }

    @Override
    public WithdrawalNotice createOrUpdateWithdrawal(WithdrawalNotice withdrawal) {
        // validates the withdrawal before saving it
        validateWithdrawal(withdrawal);
        return withdrawalNoticeDao.save(withdrawal);
    }

    @Override
    public List<WithdrawalNotice> fetchWithdrawalsByDate(LocalDate date) {
//        return withdrawalNoticeDao.getWithdrawalsByDate(date);
        return null;
    }

    @Override
    public void removeWithdrawal(Long withdrawalId) {
        withdrawalNoticeDao.deleteById(withdrawalId);
    }



    // withdrawal validations
    private void validateWithdrawal(WithdrawalNotice withdrawal) {
        // Retrieve the product
        Product product = productService.loadProductById(withdrawal.getProduct().getProductId());

        // Retrieve the investor
        Investor investor = investorService.loadInvestorById(withdrawal.getInvestor().getInvestorId());

        // Check if the investor product is a Retirement product
        if (investor.getInvestorAge() <= 65 && product.getProductType().toLowerCase() == "retirement") {
            throw new ValidationException("Investor age should be greater than 65 for Retirement product");
        }

        // Check if the withdrawal amount is greater than the current balance
        if (withdrawal.getWithdrawalAmount() > product.getProductBalance()) {
            throw new ValidationException("Withdrawal amount cannot be greater than the current balance");
        }

        // Check if the investor is withdrawing more than 90% of the current balance
        double maxWithdrawalAmount = product.getProductBalance() * 0.9;
        if (withdrawal.getWithdrawalAmount() > maxWithdrawalAmount) {
            throw new ValidationException("Investor cannot withdraw more than 90% of the current balance");
        }
    }
}
