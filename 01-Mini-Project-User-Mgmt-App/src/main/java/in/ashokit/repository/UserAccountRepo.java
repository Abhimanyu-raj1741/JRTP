package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entities.UserAccount;
import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
   
  @Modifying  // it is used to modify  the user record
  @Transactional  // 
  @Query("update UserAccount set activeSw=:status where userId=:userId")
 public void updateUserAccStatus(Integer userId,String status)	;
	
    
}
