package com.admiral.employee.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admiral.employee.onboarding.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	Optional<UserInfo> findByEmail(String email);
	

}
