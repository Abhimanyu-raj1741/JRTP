package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Customer;
import in.ashokit.dao.CustomerDao;

@Service
public class CustomerService {
   
	@Autowired
	private CustomerDao dao;
	
	public List<Customer> loadAllCustomer(){
		
		List<Customer> customers = dao.getCustomers();
		return customers;
		
		
	}
	
}
