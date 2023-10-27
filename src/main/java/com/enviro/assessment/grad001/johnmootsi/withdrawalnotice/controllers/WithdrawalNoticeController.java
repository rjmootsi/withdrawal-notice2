package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.controllers;


import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Notification;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.InvestorServiceImplementation;
import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.serviceImplementations.WithdrawalNoticeServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class WithdrawalNoticeController {

    private InvestorServiceImplementation investorService;
    private WithdrawalNoticeServiceImplementation withdrawalNoticeService;

    public WithdrawalNoticeController(InvestorServiceImplementation investorService, WithdrawalNoticeServiceImplementation withdrawalNoticeService) {
        this.investorService = investorService;
        this.withdrawalNoticeService = withdrawalNoticeService;
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

    // Add investor
    @PostMapping("/investors")
    public ResponseEntity<Void> addInvestor(@RequestBody Investor investor) {
       investorService.updateInvestor(investor);
       return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    // Create a withdrawal notice
    @PostMapping("/withdrawal-notice")
    public ResponseEntity<WithdrawalNotice> createWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice) {
        WithdrawalNotice withdrawalNotice1 = withdrawalNoticeService.createOrUpdateWithdrawal(withdrawalNotice);
        return new ResponseEntity<WithdrawalNotice>(withdrawalNotice1, HttpStatus.CREATED);
    }

}
