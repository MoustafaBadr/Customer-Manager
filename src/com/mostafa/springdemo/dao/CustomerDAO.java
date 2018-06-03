package com.mostafa.springdemo.dao;

import java.util.List;

import com.mostafa.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getcustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getcustomer(int theID);

	public void deleteCustomer(int theID);
}
