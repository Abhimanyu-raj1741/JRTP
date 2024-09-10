package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.citizenAppEntity;

public interface CitizenAppRepo  extends JpaRepository<citizenAppEntity,Integer>{
  
	public citizenAppEntity findByCitizenSsn(Long Ssn);
	
	public List<citizenAppEntity> findByCreatedBy(Integer userId);
}
