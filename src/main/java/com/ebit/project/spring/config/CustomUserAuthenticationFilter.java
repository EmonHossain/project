package com.ebit.project.spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class CustomUserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private String extraParameter;
	private String delimiter=":";
	
	

	public String getExtraParameter() {
		return extraParameter;
	}



	public void setExtraParameter(String extraParameter) {
		this.extraParameter = extraParameter;
	}



	public String getDelimiter() {
		return delimiter;
	}



	public void setDelimetir(String delimiter) {
		this.delimiter = delimiter;
	}



	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String username = request.getParameter(getUsernameParameter());
        String extraInput = request.getParameter(getExtraParameter());

        String combinedUsername = username + getDelimiter() + extraInput;

        System.out.println("Combined username = " + combinedUsername);
        return combinedUsername;
		//return super.obtainPassword(request);
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		final long companyId = Long.parseLong(request.getParameter("company"));
		request.getSession().setAttribute("companyName", companyId);
		return super.attemptAuthentication(request, response);
	}
	
	
}
