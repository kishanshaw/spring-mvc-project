package com.springmvc.demo.service;

import java.util.List;

import com.springmvc.demo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);


}
