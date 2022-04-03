package com.Kamal.ProjectTrial2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Kamal.ProjectTrial2.UserDetails.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	/* We are Using Phone as Password*/
	@Query(value = "select * from user where email= :email AND phone = :pass", nativeQuery = true)
	User validateUserIdByPhone(@Param("email") String email, @Param("pass") String pass);

}
