package in.ashokit.runner;

import java.sql.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteAll();
		
		CitizenPlan p1  = 
				new CitizenPlan("Abhimanyu Kumar", "abhimanyu.raj@gmail.com", 1234544l, 984545l,"Male","Cash" ,"Approved" , LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p2  = 
				new CitizenPlan("Ashish Kumar", "ashish@gmail.com", 9234544l, 684545l,"Male","Cash" ,"Denied" , null, null);

		CitizenPlan p3  = 
				new CitizenPlan("Bratin", "bratin@in.com", 7234544l, 784545l,"Male","Food" ,"Approved" , LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p4  = 
				new CitizenPlan("Shikha", "shikha@in.com", 6424544l, 982245l,"Fe-Male","Food" ,"Denied" , null, null);

		CitizenPlan p5  = 
				new CitizenPlan("Muskan", "muskan@in.com", 44124544l, 781245l,"Fe-Male","Medical" ,"Approved" , LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p6  = 
				new CitizenPlan("Sneha", "sneha@in.com",123344l, 92134245l,"Fe-Male","Medical" ,"Denied" , null, null);
    
		List<CitizenPlan> records = Arrays.asList(p1,p2,p3,p4,p5,p6);
		repo.saveAll(records);
	}
}
