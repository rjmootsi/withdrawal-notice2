package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.InvestmentDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investment;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.InvestmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InvestmentServiceImplementation implements InvestmentService {
    private InvestmentDao investmentDao;

    @Override
    public Investment loadInvestmentById(Long investmentId) {
        return investmentDao.findById(investmentId).orElseThrow(() -> new EntityNotFoundException("Investment id: "+investmentId+" not found"));
    }

    @Override
    public Investment createOrUpdateInvestment(Investment investment) {
        return investmentDao.save(investment);
    }
}
