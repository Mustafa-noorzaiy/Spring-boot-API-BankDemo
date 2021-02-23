package com.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.exception.ResourceNotFoundEception;
import com.bank.model.Customer;
import com.bank.repoDAO.CustomerRepoDAO;

@RestController

@RequestMapping("/api/v1")    			// To access this class by /api/v1
public class CustomerController {
					
	//we inject CustomerRepoDOA here
	
	@Autowired
	CustomerRepoDAO customerRepoDAO;
	
	//Show list of all customers as get
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerRepoDAO.findAll();
	}
	
	//update 
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
		Customer customer = customerRepoDAO.findById(id).orElseThrow(()-> new ResourceNotFoundEception("Customer is not exist: "+id));
		customer.setAccountNumber(customerDetails.getAccountNumber());
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setPhoneNumber(customerDetails.getPhoneNumber());
		customer.setEmail(customerDetails.getEmail());
		customer.setWithdraw(customerDetails.getWithdraw());
		customer.setDeposit(customerDetails.getDeposit());
		customer.setBlance(customerDetails.getBlance());
		
		Customer updateCustomer =customerRepoDAO.save(customer);
		
		return ResponseEntity.ok(customer);
	}
	
	
	// delete
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepoDAO.findById(id).orElseThrow(()-> new ResourceNotFoundEception("Customer is not exist: "+id));
		customerRepoDAO.delete(customer);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	
	
	
	
}
