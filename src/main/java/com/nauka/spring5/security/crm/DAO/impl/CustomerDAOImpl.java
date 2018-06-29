package com.nauka.spring5.security.crm.DAO.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nauka.spring5.security.crm.DAO.CustomerDAO;
import com.nauka.spring5.security.crm.domain.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id =:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchForClients(String searchCriteria) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = null;
		if (searchCriteria != null && searchCriteria.trim().length() > 0) {
		query = session.createQuery("from Customer where lower(lastName) like :search"
				+ " or lower(firstName) like :search order by lastName", Customer.class);
		query.setParameter("search", "%" + searchCriteria.toLowerCase() + "%");
		} else query = session.createQuery("from Customer order by lastName", Customer.class);
		return query.getResultList();		
	}
}