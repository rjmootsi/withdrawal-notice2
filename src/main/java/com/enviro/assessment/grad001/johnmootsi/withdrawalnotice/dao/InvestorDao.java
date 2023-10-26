package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestorDao extends JpaRepository<Investor, Long> {
    // Method not available in the Repository hence added here
    // Using Java classes as opposed to Sql fields
    @Query(value = "select i from Investor as i where i.investorName like %:name% or i.investorLastname like %:name%")
    List<Investor> findInvestorsByName(@Param("name") String name);
}
