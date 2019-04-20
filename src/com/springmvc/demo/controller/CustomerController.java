package com.springmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.demo.DAO.CustomerDAO;
import com.springmvc.demo.entity.Customer;
import com.springmvc.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*@Autowired
	private CustomerDAO customerDAO;*/
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model){
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "listCustomers";
		
	}
	
	@GetMapping("/showFormForAddCustomers")
	public String showFormForAddCustomers(Model model){
		
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		
		return "customer-form";
		
	}

	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
		
	}
}
