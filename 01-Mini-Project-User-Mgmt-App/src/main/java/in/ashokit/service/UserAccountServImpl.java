package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entities.UserAccount;
import in.ashokit.repository.UserAccountRepo;

@Service
public class UserAccountServImpl implements UserAccountService{
   
	@Autowired
	private UserAccountRepo userRepo;
	
	
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		Integer userId = userAcc.getUserId();
		if(userId == null) {
			userAcc.setActiveSw("Y");
		}
		userRepo.save(userAcc);
		if(userId==null) {
			return  "User Record Saved";
		}
		else 
		{
			return "User Recorded Updated";
		}
		
		
	}
	public List<UserAccount> getAllUserAccounts(){
		
		//List<UserAccount> lst = userRepo.findAll();
		
		//return lst;
		
		return userRepo.findAll();
		
	}
	public UserAccount getUserAcc(Integer userId)
	{
		
		Optional<UserAccount> op = userRepo.findById(userId);
	    if(op.isPresent()) {
	    	return op.get();
	    }
	    else
	    {
	    	return null;
	    }
		
	}
	public boolean deleteUserAcc(Integer userId) {
		
		/*
		 * try { userRepo.deleteById(userId); return true; } catch(Exception e) {
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * return false;
		 */
		boolean existsById = userRepo.existsById(userId);
		if(existsById)
		{
		   userRepo.deleteById(userId)	;
		   return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean updateUserAccStatus(Integer userId,String status) {
		
		try {
			userRepo.updateUserAccStatus(userId, status);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
