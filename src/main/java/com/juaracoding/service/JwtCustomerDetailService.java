package com.juaracoding.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.juaracoding.Repository.CustomerRepository;
import com.juaracoding.model.CustomerModel;

@Service
public class JwtCustomerDetailService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		CustomerModel customer = customerRepo.findByUsername(username);
		return new User(customer.getUsername(), customer.getPassword(),
				new ArrayList<>());
	}
	
}
