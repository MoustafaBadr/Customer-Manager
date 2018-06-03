package com.mostafa.springdemo.service;

import java.util.List;

import com.mostafa.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getcustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getcustomer(int theID);

	public void deleteCustomer(int theID);
}
