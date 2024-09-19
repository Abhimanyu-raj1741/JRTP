package in.ashokit.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import in.ashokit.bindings.*;
public class CustomerDao {
    
	public List<Customer> getCustomers(){
		
		
	return 	IntStream.rangeClosed(1, 10).mapToObj(i->new Customer(i,"customer"+i)).collect(Collectors.toList());
	}
}
