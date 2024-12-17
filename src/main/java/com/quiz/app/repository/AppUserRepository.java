package com.quiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	 AppUser findByName(String name);

}
