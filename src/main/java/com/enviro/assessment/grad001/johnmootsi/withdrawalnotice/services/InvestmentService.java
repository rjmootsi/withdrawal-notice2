package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investment;

public interface InvestmentService {

    Investment loadInvestmentById(Long investmentId);
}
