//package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.controllers;
//
//import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.services.InvestorService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/api/v1/investor")
//public class InvestorController {
//
//    private InvestorService investorService;
//
//    public InvestorController(InvestorService investorService) {
//        this.investorService = investorService;
//    }
//
//    @GetMapping("/{investorId}")
//    public ResponseEntity<Investor> getInvestor(@PathVariable Long investorId) {
//        Investor investor = investorService.getInvestor(investorId);
//        if (investor != null) {
//            return ResponseEntity.ok(investor);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/{investorId}/products")
//    public ResponseEntity<List<Product>> getInvestorProducts(@PathVariable Long investorId) {
//        List<Product> products = investorService.getInvestorProducts(investorId);
//        if (!products.isEmpty()) {
//            return ResponseEntity.ok(products);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//    @PostMapping("/{investorId}/withdrawals")
//    public ResponseEntity<?> createWithdrawal(@PathVariable Long investorId, @RequestBody WithdrawalRequest withdrawalRequest) {
//        try {
//            investorService.createWithdrawal(investorId, withdrawalRequest);
//            return ResponseEntity.ok().build();
//        } catch (ValidationException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
