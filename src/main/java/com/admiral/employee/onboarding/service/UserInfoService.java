package com.admiral.employee.onboarding.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.admiral.employee.onboarding.dto.UserInfoDetails;
import com.admiral.employee.onboarding.entity.UserInfo;
import com.admiral.employee.onboarding.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserInfo> userDetail = userInfoRepository.findByEmail(username);
		
		return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found : "+ username));
	}
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(bcryptPasswordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "User Added Successfully";
	}
}
