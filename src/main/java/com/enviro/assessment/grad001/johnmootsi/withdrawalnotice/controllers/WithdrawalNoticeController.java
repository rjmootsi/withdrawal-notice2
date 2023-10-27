package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.controllers;


import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investment;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Product;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.InvestmentServiceImplementation;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.InvestorServiceImplementation;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.ProductServiceImplementation;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.WithdrawalNoticeServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class WithdrawalNoticeController {

    private InvestorServiceImplementation investorService;
    private WithdrawalNoticeServiceImplementation withdrawalNoticeService;
    private ProductServiceImplementation productService;
    private InvestmentServiceImplementation investmentService;

    public WithdrawalNoticeController(InvestorServiceImplementation investorService, WithdrawalNoticeServiceImplementation withdrawalNoticeService, ProductServiceImplementation productService, InvestmentServiceImplementation investmentService) {
        this.investorService = investorService;
        this.withdrawalNoticeService = withdrawalNoticeService;
        this.productService = productService;
        this.investmentService = investmentService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Oh hai, world!";
    }

    // Get investor info
    @GetMapping("/investors/{id}")
    public ResponseEntity<Investor> getInvestorInfo(@PathVariable(name = "id") Long investorId) {
        Investor investor = investorService.loadInvestorById(investorId);
        return new ResponseEntity<Investor>(investor, HttpStatus.OK);
    }

    // Get products
    @GetMapping("/products/{keyword}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String keyword) {
        List<Product> products = productService.findProductsByProductType(keyword);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    // Add investor
    @PostMapping("/investors")
    public ResponseEntity<Void> addInvestor(@RequestBody Investor investor) {
       investorService.updateInvestor(investor);
       return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    // Make an investment
    @PostMapping("/investments")
    public ResponseEntity<Void> addInvestment(@RequestBody Investment investment) {
        investmentService.createOrUpdateInvestment(investment);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    // Create a withdrawal notice
    @PostMapping("/withdrawal-notice")
    public ResponseEntity<WithdrawalNotice> createWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice) {
        WithdrawalNotice withdrawalNotice1 = withdrawalNoticeService.createOrUpdateWithdrawal(withdrawalNotice);
        return new ResponseEntity<WithdrawalNotice>(withdrawalNotice1, HttpStatus.CREATED);
    }

}
