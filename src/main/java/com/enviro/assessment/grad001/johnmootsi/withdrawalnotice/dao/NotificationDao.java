package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.dao;

import com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDao extends JpaRepository<Notification, Long> {
}
