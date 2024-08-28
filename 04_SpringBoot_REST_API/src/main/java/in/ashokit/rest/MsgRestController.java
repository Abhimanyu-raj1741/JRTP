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
		logger.trace("this is log  - trace msg");
		logger.debug("this is log - debug msg ");
		logger.info("This is log - info msg");
		logger.warn("this is log - warn msg");
		logger.error("this is log - error msg");
		
		String msg= "Welcome to Abhimanyu Webseite";
		
		return msg;
	}
	@GetMapping("/greet")
	public String getGreetMsg() {
		String msg= "Hi Abhimanyu Good Morning ";
		return msg;
	}
}
