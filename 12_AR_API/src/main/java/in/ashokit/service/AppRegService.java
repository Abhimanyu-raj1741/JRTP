package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.CitizenApp;

public interface AppRegService {

	public String createCitizenApp(CitizenApp app);
	
	public List<CitizenApp> getApplications(Integer userId, String userType);
	
	
	
	
	
	
	
}
