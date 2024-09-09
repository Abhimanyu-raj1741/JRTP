package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.SignUpRequest;
import in.ashokit.service.UserService;

@RestController
public class UserRestController {
   
    @Autowired
	private UserService service;
    
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody SignUpRequest request)
    {
    	boolean isSaved = service.saveUser(request);
    	
    	if(isSaved)
    		return new ResponseEntity<>("Registration Successfull",HttpStatus.OK);
    	else 
    		return new ResponseEntity<>("Registration Failed",HttpStatus.OK);
    	
    }
	
}
