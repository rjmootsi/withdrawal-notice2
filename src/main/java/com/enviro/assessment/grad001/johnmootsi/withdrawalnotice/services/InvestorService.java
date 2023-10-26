package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;

import java.util.List;

public interface InvestorService {

    Investor loadInvestorById(Long investorId);
    List<Investor> findInvestorsByName(String name);
    Investor createInvestor(String investorName, String investorLastname, int investorAge, String address, String contact);
    Investor updateInvestor(Investor investor);
    List<Investor> findInvestors();
    void removeInvestor(Long investorId);
}
