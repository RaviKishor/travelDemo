package com.example.travelDemo.service;

import com.example.travelDemo.model.Customer;
import com.example.travelDemo.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "customers")
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public String save(Customer customer) {
		customerRepository.save(customer);
		return "Customer Added" + customer.getId();
	}

	public Optional<Customer> get(int id) {
		return customerRepository.findById(id);
	}

	@Cacheable(condition = "#name.equals('Ravi')")
	//@Cacheable(value ="customers", key = "#name")
	public Optional<Customer> get(String name) {
		System.out.println("Searching......." + name);
		return customerRepository.findAll().stream().filter(cust -> cust.getCustName().equals(name)).findAny();
	}

	//to clean
	@CacheEvict(allEntries = true)
	public void clearCache() {

	}
}
