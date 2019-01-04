package com.getknowledge.elastic.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getknowledge.elastic.model.Users;

public interface UsersJPARepository extends JpaRepository<Users, Long>{
	
	 List<Users> findByName(String text);

	 List<Users> findBySalary(Long salary);

}
