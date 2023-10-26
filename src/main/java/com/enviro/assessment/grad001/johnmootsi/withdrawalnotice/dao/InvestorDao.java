package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorDao extends JpaRepository<Investor, Long> {

}
