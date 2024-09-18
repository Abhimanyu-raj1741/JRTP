package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
    
	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		String msg = "welcome To Abhimanyu Website...!!";
		
		return msg;
	}
}
