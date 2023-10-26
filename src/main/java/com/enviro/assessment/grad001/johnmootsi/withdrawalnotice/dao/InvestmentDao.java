package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentDao extends JpaRepository<Investment, Long> {
}
