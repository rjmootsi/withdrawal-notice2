package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class WithdrawalNoticeController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Oh hai, world!";
    }


}
