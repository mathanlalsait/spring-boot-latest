package com.candidjava.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.candidjava.springboot.entity.Employee;
import com.candidjava.springboot.entity.Role;
import com.candidjava.springboot.service.EmployeeService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Employee employee = null;
		employee = employeeService.findByEmail(email);
		if (employee == null) {
			throw new UsernameNotFoundException("Employee Not Found : " + email);
		}
		List<GrantedAuthority> authorities = buildUserAuthority(employee.getRoles());
		return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), authorities);

	}

	private AuthenticateUser buildUserForAuthentication(Employee employee, List<GrantedAuthority> authorities) {
		return new AuthenticateUser(employee.getEmail(), employee.getPassword(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Collection<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// add user's authorities
		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	static class AuthenticateUser implements UserDetails {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private String username;
		private String password;
		public Collection<? extends GrantedAuthority> authorities;

		public AuthenticateUser(String username, String password, List<GrantedAuthority> authorities) {
			this.username = username;
			this.password = password;
			this.authorities = authorities;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

	}

}
