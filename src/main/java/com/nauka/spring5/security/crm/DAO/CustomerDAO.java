package com.nauka.spring5.security.crm.DAO;

import java.util.List;

import com.nauka.spring5.security.crm.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
	public List<Customer> searchForClients(String searchCriteria);
}