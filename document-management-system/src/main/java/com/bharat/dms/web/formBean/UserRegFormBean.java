package com.bharat.dms.web.formBean;

import java.util.Arrays;

public class UserRegFormBean {

	public String username;
	public String password;
	public String rePassword;
	public String[] roles;
	
	
	public UserRegFormBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserRegFormBean [password=" + password + ", rePassword="
				+ rePassword + ", roles=" + Arrays.toString(roles)
				+ ", username=" + username + "]";
	}

}
