package com.javainuse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javainuse.model.MyUser;

public interface UserRepo extends JpaRepository<MyUser, Integer> {
	@Query("from MyUser where name=:name")
	MyUser findByUserName(@Param("name") String name);

}
