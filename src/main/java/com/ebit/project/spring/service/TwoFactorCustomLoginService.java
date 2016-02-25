package com.ebit.project.spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TwoFactorCustomLoginService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String combinedData) throws UsernameNotFoundException {
		String[] split = combinedData.split(":");
	    if(split.length < 2){
	    	throw new UsernameNotFoundException("Must specify both username and corporate domain");
	    }
	    
	    String username = split[0];
	    String domain = split[1];
	    
	    User user = userDao.findByUsernameAndDomain(username, domain);
	    if(user == null)
	    {
	        System.out.println("User could not be found, must be an invalid username/domain combo.");
	        throw new UsernameNotFoundException("Invalid username or corporate domain");
	    }

	    System.out.println("Returning user: " + user);
	    return user;
	}

}
