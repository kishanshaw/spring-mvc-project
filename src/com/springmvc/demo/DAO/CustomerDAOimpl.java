package com.springmvc.demo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.demo.entity.Customer;

@Repository             //@Repository are used with DAO implementation, this will handle all the DAO related exception
public class CustomerDAOimpl implements CustomerDAO {

	
	//need to inject the session factory so that the DAO impl can make use of it. 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional - this will begin and end transactions automatically, no need to call begin and end transactions explicitly 
	public List<Customer> getCustomers() {
		
		//get the session object using the injected session factory object above
		Session session = sessionFactory.getCurrentSession();
		
		// create the query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		//get the result set
		List<Customer> customers =query.getResultList();
		
		//retun the list 
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int Id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", Id);
		query.executeUpdate();
		
		
	}

}
