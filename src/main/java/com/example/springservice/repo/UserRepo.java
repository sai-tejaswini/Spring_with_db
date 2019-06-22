package com.example.springservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.springservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	@Transactional
	@Modifying
	@Query("update User user set user.gender =:gender where user.id =:id")
	void updateById(@Param("gender") String gender,@Param("id") long id);
}
