package in.ashokit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	
	@GetMapping("/product")
	public String getProductInfo() {
		
		logger.info("Product() method execution start....");
		
		String msg = null;
		msg.length();
		
		logger.info("Product() method execution end....");
		return "Product Not Avaliable";
	}
}
