package com.bank.repoDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;
@Repository
public interface CustomerRepoDAO extends JpaRepository<Customer, Long> {

}
