package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao.InvestorDao;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.InvestorService;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.ProductService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class InvestorServiceImplementation implements InvestorService {
    private InvestorDao investorDao;
    private ProductService productService;

    public InvestorServiceImplementation(InvestorDao investorDao, ProductService productService) {
        this.investorDao = investorDao;
        this.productService = productService;
    }

    @Override
    public Investor loadInvestorById(Long investorId) {
        return investorDao.findById(investorId).orElseThrow(() -> new EntityNotFoundException("Investor with id: "+investorId+" not found"));
    }

    @Override
    public List<Investor> findInvestorsByName(String name) {
        return investorDao.findInvestorsByName(name);
    }

    @Override
    public Investor createInvestor(String investorName, String investorLastname, int investorAge, String address, String contact) {
        return investorDao.save(new Investor(investorName, investorLastname, investorAge, contact, address));
    }

    @Override
    public Investor updateInvestor(Investor investor) {
        return investorDao.save(investor);
    }

    @Override
    public List<Investor> findInvestors() {
        return investorDao.findAll();
    }

    @Override
    public void removeInvestor(Long investorId) {
        Investor investor = loadInvestorById(investorId);
        // First remove all the products associated with the investor
        for (Product product: investor.getProducts()) {
            productService.removeProduct(product.getProductId());
        }
        // Finally remove the investor
        investorDao.deleteById(investorId);
    }
}
