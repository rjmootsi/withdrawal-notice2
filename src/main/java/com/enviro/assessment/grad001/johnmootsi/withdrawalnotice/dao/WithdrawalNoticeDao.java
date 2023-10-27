package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WithdrawalNoticeDao extends JpaRepository<WithdrawalNotice, Long> {
    // get withdrawals by date
//    @Query(value = "select w from WithdrawalNotice as w where w.date=: date")
//    List<WithdrawalNotice> getWithdrawalsByDate(@Param("date") LocalDate date);

    // get withdrawals by investor id
//    @Query(value = "select * from withdrawals as w where w.withdrawalId in (select i.investorId from investors as i where i.investorId=:inverstorId)", nativeQuery = true)
//    List<WithdrawalNotice> getWithdrawalsByInvestorId(@Param("investorId") Long investorId);
}
