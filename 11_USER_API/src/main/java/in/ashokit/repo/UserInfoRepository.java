package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import in.ashokit.entity.*;
public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {
       
	
}
