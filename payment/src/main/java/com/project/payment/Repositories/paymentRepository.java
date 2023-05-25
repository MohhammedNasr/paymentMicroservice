package com.project.payment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.models.pay;

@Repository
public interface paymentRepository extends JpaRepository<pay, Long> {

}