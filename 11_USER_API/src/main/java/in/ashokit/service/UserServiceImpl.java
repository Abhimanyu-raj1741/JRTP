package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserEntity;
import in.ashokit.repo.UserInfoRepository;
import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.DashboardResponse;
import in.ashokit.response.LoginResponse;
import in.ashokit.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepository userrepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean saveUser(SignUpRequest request) {
       
		// generate temporary pwd
		
		  String tempPwd = generateTempPwd();
		  request.setPwd(tempPwd);
		  request.setPwdChanged(false);
		  
		// save user record in db
		 
		  UserEntity entity = new UserEntity();
		  BeanUtils.copyProperties(request,entity);
		  userrepo.save(entity);
	
		  
		// send email to user with credentials
		  String subject =" IES-Accout Created";
		  
		  String body ="Hi , "+request.getName()+" Your Temp Password for Login : "+ tempPwd;
		  boolean isSent = emailUtils.sendEmail(request.getEmail(),subject, body);

		return (isSent)?true:false;
	}

	@Override
	public LoginResponse usserLogin(LoginRequest request) {
		
		LoginResponse response = new LoginResponse();
		
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPwd(request.getPwd());
		
		Example<UserEntity> of = Example.of(entity);
		List<UserEntity> entities = userrepo.findAll(of);
		
		if(!entities.isEmpty())
		{
			UserEntity user = entities.get(0);
			response.setUserid(user.getUserid());
			response.setUserType(user.getUserType());
			
			if(user.isPwdChanged()) {
				//second login 
				response.setPwdChanged(true);
				response.setValidLogin(true);
				
				//set dashboard response
				DashboardResponse dashboard = new DashboardResponse();
				dashboard.setPlansCount(6);
				dashboard.setBenifitAmtTotal(3400.00);
				dashboard.setCitizensApcnt(1000l);
				dashboard.setCitizensDnCnt(500l);
				
				response.setDashboard(dashboard);
				
			}
			else 
			{
				// first login 
				response.setPwdChanged(false);
				response.setValidLogin(false);
			}
		}
		else {
			response.setValidLogin(false);
		}
		
		
		return response;
	}

	@Override
	public LoginResponse updatePwd(PwdChangeRequest request) {
		// TODO Auto-generated method stub
		  Integer userid = request.getUserid();
		  
		  LoginResponse response = new LoginResponse();
		  Optional<UserEntity> byId = userrepo.findById(userid);
		
		  if(byId.isPresent())
		  {   // update pwd 
			  UserEntity entity =byId.get();
			  entity.setPwd(request.getPwd());
			  entity.setPwdChanged(true);
			  userrepo.save(entity);
			  
			  // construct dashboard response 
			  response.setValidLogin(true);
			  DashboardResponse dashboard = new DashboardResponse();
			  dashboard.setPlansCount(61);
			  dashboard.setBenifitAmtTotal(3400.00);
			  dashboard.setCitizensApcnt(1000l);
			  dashboard.setCitizensDnCnt(500l);
			  response.setDashboard(dashboard);
			  
			  
			 
		  }
		
		return response;
	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		UserEntity  user = userrepo.findByEmail(email);
		if(user==null)
		{
			return false;
		}
		String subject ="IES - Recover Password";
		String body  = "Your Password  :: "+ user.getPwd();
		
		return emailUtils.sendEmail(email, subject, body);
		
	}
	
	public String generateTempPwd() {
	    
		// create a string of all characters 
		String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		
		// create random string builder
		StringBuilder sb = new StringBuilder();
		
		// create an object of Random class
		Random random = new Random();
		
		// Specify the length of random String
		int length = 7;
		
		for(int i=0;i<length;i++)
		{
			//generate random index number
			int index = random.nextInt(alphabet.length());
			
			char randomChar = alphabet.charAt(index);
			
			sb.append(randomChar);
		}
		
		
		return sb.toString() ;
	}
	

}
