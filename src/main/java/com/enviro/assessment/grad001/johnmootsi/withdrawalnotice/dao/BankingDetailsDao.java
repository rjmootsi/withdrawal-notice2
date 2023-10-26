package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.BankingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingDetailsDao extends JpaRepository<BankingDetails, Long> {
}
