package com.nauka.spring5.security.crm.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nauka.spring5.security.crm.DAO.CustomerDAO;
import com.nauka.spring5.security.crm.domain.Customer;
import com.nauka.spring5.security.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);		
	}

	@Override
	@Transactional
	public List<Customer> searchForClients(String searchCriteria) {
		return customerDAO.searchForClients(searchCriteria);
	}
}