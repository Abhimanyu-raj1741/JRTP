package in.ashokit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	Logger logger = LoggerFactory.getLogger(MsgRestController.class);
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		// Logger level 
		logger.info(" welcome() method execution start...");
		
		String msg= "Welcome to Abhimanyu Webseite";
		
		logger.info("welcome () method execution end....");
		
		return msg;
	}
	@GetMapping("/greet")
	public String getGreetMsg() {
		
		logger.info("Greet () method execution end....");
		
		String msg= "Hi Abhimanyu Good Morning ";
		
		logger.info("Greet () method execution end....");
		
		return msg;
	}
}
