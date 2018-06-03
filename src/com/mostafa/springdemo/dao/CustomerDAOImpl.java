package com.mostafa.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mostafa.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getcustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query...sort by the last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {

		// get current hibernate session
		Session currentsession = sessionFactory.getCurrentSession();
		// save/update the customer
		currentsession.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getcustomer(int theID) {

		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// retrieve from database using the primary key
		Customer thecustomer = session.get(Customer.class, theID);
		return thecustomer;
	}

	@Override
	public void deleteCustomer(int theID) {
		// get current hibernate session
				Session session = sessionFactory.getCurrentSession();
		//delete the object with the primary key
				Query query=session .createQuery("delete from Customer where id=:customerId");
				
				query.setParameter("customerId",theID);

				//execute delete
				query.executeUpdate();
	}

}








