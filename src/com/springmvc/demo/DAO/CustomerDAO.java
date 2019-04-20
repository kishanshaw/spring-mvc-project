package com.springmvc.demo.DAO;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.springmvc.demo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);


}
