package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.CitizenApp;
import in.ashokit.entity.citizenAppEntity;
import in.ashokit.repo.CitizenAppRepo;

public class AppRegServiceImpl implements AppRegService{
	
	
	private String SSA_API_URL="http://192.168.3.1:8080/ssn/{ssn}";
	
	@Autowired
	private CitizenAppRepo appRepo;
	
	@Override
	public String createCitizenApp(CitizenApp app) {
		// TODO Auto-generated method stub
		Long citizenSsn = app.getCitizenSsn();
		
		citizenAppEntity byCitizenSsn = appRepo.findByCitizenSsn(app.getCitizenSsn());
		
		if(byCitizenSsn!=null)
		{
			return "Duplicate Application ";
		}
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = 
				rt.getForEntity(SSA_API_URL,String.class, citizenSsn);
		
		String body =  forEntity.getBody();
		
		if(body.equals("Rhode Island"))
		{
			citizenAppEntity entity = new citizenAppEntity();
			BeanUtils.copyProperties(app, entity);
			citizenAppEntity save = appRepo.save(entity);
			return "Application Created with Case Number -"+ save.getCaseNum();
		}
		
		return "Invalid SSN";
	}

	@Override
	public List<CitizenApp> getApplications(Integer userId, String userType) {
		// TODO Auto-generated method stub
		List<citizenAppEntity> entities = null;
		List<CitizenApp> apps = new ArrayList<>();
		if("Admin".equals(userType)) {
			 entities= appRepo.findAll();
			
		}else {
			entities = appRepo.findByCreatedBy(userId);
		}
			
		for(citizenAppEntity entity : entities)
		{
			CitizenApp app = new CitizenApp();
			BeanUtils.copyProperties(entity, app);
			apps.add(app);
		}
		
		return apps;
	}
	
	
	
	
	
	
	
	
	
	

}
