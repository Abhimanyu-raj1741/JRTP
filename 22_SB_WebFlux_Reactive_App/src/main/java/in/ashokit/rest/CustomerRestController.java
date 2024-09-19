package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Customer;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {
   
	@Autowired
	private CustomerService service;
	
	@GetMapping("/")
	public List<Customer> getCustomer(){
		return service.loadAllCustomer();
	}
}
