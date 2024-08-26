package in.ashokit.utils;

import java.io.File;

import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
    
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(File file)
	{
		boolean status = false;
		// 
		// we have two types of tecnieque to send the messagge 
		// 1 ) Simple Message  : plain text data
		// 2 ) Mime Message : Formatted text & attachements 
		try {
			MimeMessage  msg = mailSender .createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo("alexmersia@gmail.com");
			helper.setSubject("Your Report  from Abhimanyu  App");
			helper.setText("<h2> PLease download your report </h2> ", true);
			helper.addAttachment(file.getName(), file);
			
			mailSender.send(msg);
			
			status = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return status;
	}
	
}
