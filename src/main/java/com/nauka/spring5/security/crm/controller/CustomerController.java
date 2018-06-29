package com.nauka.spring5.security.crm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nauka.spring5.security.crm.domain.Customer;
import com.nauka.spring5.security.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "customer/customer-list";
	}
	
	@RequestMapping("/add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/customer-form";
	}
	
	@RequestMapping("/update")
	public String updateCustomer(Model model, @RequestParam("id") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer/customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String deleteCustomer(Model model, @RequestParam("searchCriteria") String searchCriteria) {
		List<Customer> customers = customerService.searchForClients(searchCriteria);
		model.addAttribute("customers", customers);
		return "customer-list";
	}
}