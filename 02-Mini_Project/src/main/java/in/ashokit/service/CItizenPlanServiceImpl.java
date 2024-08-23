package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Binding.SearchCriteria;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CItizenPlanServiceImpl implements CitizenPlanService{
	
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}
	
	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void generateExcel(HttpServlet response) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void generatePdf(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
