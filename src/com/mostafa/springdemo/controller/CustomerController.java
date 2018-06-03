package com.mostafa.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mostafa.springdemo.entity.Customer;
import com.mostafa.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject customer Service in this controller
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customer from the service
		List<Customer> thecustomers = customerService.getcustomers();

		// add the customers to the model
		model.addAttribute("customers", thecustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Customer tempcustomer = new Customer();

		model.addAttribute("customer", tempcustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		// save the customer using our service
		customerService.saveCustomer(thecustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theID, Model model) {

		// get the customer from our service
		Customer tempcustomer = customerService.getcustomer(theID);

		// set customer as a model attribute to pre-popluate the form
		model.addAttribute("customer", tempcustomer);

		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theID, Model model) {
	
		//delete the customer
		customerService.deleteCustomer(theID);
		return "redirect:/customer/list";
	}

}
