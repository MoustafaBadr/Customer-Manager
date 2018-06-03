package com.mostafa.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mostafa.springdemo.dao.CustomerDAO;
import com.mostafa.springdemo.entity.Customer;

@Service
public class CustomerServiceImpo implements CustomerService {

	// need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getcustomers() {
		return customerDAO.getcustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		customerDAO.saveCustomer(thecustomer);
	}

	@Override
	@Transactional
	public Customer getcustomer(int theID) {
		return customerDAO.getcustomer(theID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theID) {
		 customerDAO.deleteCustomer(theID);
	}

}
