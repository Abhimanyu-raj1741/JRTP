package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CitizenApp;
import in.ashokit.service.AppRegService;
import in.ashokit.service.AppRegServiceImpl;
import jakarta.websocket.server.PathParam;

@RestController
public class AppRestController {

    @Autowired
	private AppRegService service;
	
	@PostMapping("/app")
    public ResponseEntity<String> createApp(@RequestBody CitizenApp app){
    	
    	String response = service.createCitizenApp(app);
    	
    	return new ResponseEntity<>(response,HttpStatus.OK);
    	
    }
	
	@GetMapping("/user/{userId}/{userType}")
	public ResponseEntity<List<CitizenApp>> getApplication(@PathVariable  Integer userId, String userType ){
		
		List<CitizenApp> applications = service.getApplications(userId, ssn);
		
		return new ResponseEntity<>(applications,HttpStatus.OK);
	}
	
	
}
