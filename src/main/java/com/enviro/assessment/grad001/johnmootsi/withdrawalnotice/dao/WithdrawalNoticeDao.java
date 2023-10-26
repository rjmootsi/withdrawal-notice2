package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalNoticeDao extends JpaRepository<WithdrawalNotice, Long> {
}
